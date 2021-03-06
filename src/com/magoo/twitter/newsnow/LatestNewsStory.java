package com.magoo.twitter.newsnow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.magoo.twitter.Publisher;

public class LatestNewsStory {

	private static final Logger LOG = Logger.getLogger(LatestNewsStory.class);

	private static List<String> excludesList;

	private static Properties config;

	private static String url;
	private static String hashtag;
	private static String status;
	private static String filename;

	private static Integer count;

	public LatestNewsStory() {
		count = 1;
	}

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		LOG.info("====================BEGIN=======================");
		LatestNewsStory engine = new LatestNewsStory();
		engine.parseConfig(args);
		if (engine.isTweetADuplicate()) {
			LOG.info("Duplicate... exiting...");
		} else if (engine.isTweetExcluded()) {
			LOG.info("Excluded tweet.. exiting...");
		} else {
			engine.publishTweet();
		}
		LOG.info("==================== END =======================");
	}

	private void parseConfig(String[] args) throws FileNotFoundException, IOException {
		filename = args[0];
		// The story count ordinal to use from the list of stories
		if (args.length == 2) {
			count = Integer.parseInt(args[1]);
		}
		// The config parser
		config = new Properties();
		config.load(new FileInputStream(filename));
		url = config.getProperty("url");
		hashtag = config.getProperty("hashtag");
		status = getStatus(url, hashtag, count);

		// exclude list is ; separated
		String excludeString = config.getProperty("exclude");
		if (excludeString != null) {
			String[] excludesArray = excludeString.split(";");
			excludesList = Arrays.asList(excludesArray);
		}
	}

	private static String getStatus(String url, String hashtag, int count) throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");

		LOG.info("Links: " + links.size());
		String tweet = "";
		int i = 1;
		for (Element link : links) {
			String href = link.attr("abs:href");
			if (href.contains("?-")) {
				if (i == count) {
					Element p = link.parent();
					Elements s = p.getElementsByTag("b");
					String src = s.text();
					tweet = link.text() + " " + link.attr("abs:href") + " [" + src + "]\n";
					tweet += " " + hashtag;
					break;
				}
				i++;
			}
		}
		return trim(tweet, 165);
	}

	private static String trim(String s, int width) {
		if (s.length() > width) {
			return s.substring(0, width - 1) + ".";
		} else {
			return s;
		}
	}

	private boolean isTweetADuplicate() throws IOException {
		File f = new File("log/" + filename + ".log");
		if (!f.exists()) {
			LOG.info("Creating file: " + f);
			f.createNewFile();
		} else {
			BufferedReader r = new BufferedReader(new FileReader(f));
			String lastTweet = r.readLine();
			r.close();
			if (lastTweet != null) {
				LOG.info("Last tweet: '" + lastTweet + "'");
				String newTweet = status.substring(0, status.indexOf("\n"));
				LOG.info("Full tweet: '" + status + "'");
				LOG.info("Next tweet: '" + newTweet + "'");
				if (lastTweet.equals(newTweet)) {
					return true;
				}
			}
		}
		LOG.info(status);
		BufferedWriter w = new BufferedWriter(new FileWriter(f));
		w.write(status);
		w.close();
		return false;
	}

	private boolean isTweetExcluded() {
		if (excludesList != null) {
			for (String word : excludesList) {
				if (status.contains(word)) {
					LOG.info("excluded word: " + word + " exists in: " + status);
					return true;
				}
			}
		}
		return false;
	}

	private void publishTweet() throws FileNotFoundException, IOException {
		Publisher publisher = new Publisher(status);
		publisher.init(config);
		publisher.publish();
	}

}

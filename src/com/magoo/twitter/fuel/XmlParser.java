package com.magoo.twitter.fuel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class XmlParser {

    private Document doc;

    public XmlParser(Properties config) throws IOException {
        String url = config.getProperty("url");
        print("Fetching %s...", url);
        Document doc = Jsoup.connect(url).get();
        this.doc = doc;
    }

    @SuppressWarnings("deprecation")
    public String process() {
        Date today = new Date();
        Date twoWeeksAgo = new Date(today.getTime() - 14 * 86400 * 1000);
        Elements tables = doc.select("station");
        SortedSet<String> set = new TreeSet<String>();
        for (Element table : tables) {
            Date date = StringToDate(table.attr("dateupdated"));
            if (isWithinTwoWeeks(twoWeeksAgo, date)) {
                set.add(table.attr("price") + ":" + table.attr("name") + " " + table.attr("addr2"));
            }
        }
        String msg = "";
        for (String s : set) {
            msg += s + "\n";
        }
        print("---------------------------------");
        msg = trim(msg, 137);
        msg += "[" + today.getDay() + "]";
        msg = trim(msg, 140);
        print(msg + ":" + msg.length());
        print("---------------------------------");
        return msg;
    }

    private static String trim(String s, int width) {
        if (s.length() > width) {
            return s.substring(0, width);
        } else {
            return s;
        }
    }

    private static boolean isWithinTwoWeeks(Date twoWeeksAgo, Date updated) {
        return twoWeeksAgo.compareTo(updated) < 0;
    }

    private static Date StringToDate(String d) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

}

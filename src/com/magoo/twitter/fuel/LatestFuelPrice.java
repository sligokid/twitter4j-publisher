package com.magoo.twitter.fuel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.magoo.twitter.Publisher;

public class LatestFuelPrice {

	private static final Logger LOG = Logger.getLogger(LatestFuelPrice.class);

	public static void main(String args[]) throws IOException {
		BasicConfigurator.configure();
		LOG.info("====================BEGIN=======================");
		String configFile = args[0];
		Properties properties = new Properties();
		properties.load(new FileInputStream(configFile));

		XmlParser parser = new XmlParser(properties);
		String status = parser.process();

		Publisher publisher = new Publisher(status);
		publisher.init(properties);
		publisher.publish();
		LOG.info("==================== END =======================");
	}

}

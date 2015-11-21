package com.magoo.twitter.fuel;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class XmlParserTest {

	private XmlParser xmlParser;

	@Before
	public void before() throws IOException {
		Properties config = new Properties();
		config.setProperty("url", "https://twitter.com/");

		xmlParser = new XmlParser(config);
	}

	@Test
	public void constructing_parser_loads_document_from_url() throws IOException {
		assertNotNull(xmlParser.getScraper());
	}

	@Test
	public void processing_parser_returns_a_meesage() {
		assertNotNull(xmlParser.process());
	}

}

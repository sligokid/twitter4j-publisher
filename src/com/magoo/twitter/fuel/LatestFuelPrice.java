package com.magoo.twitter.fuel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.magoo.twitter.Publisher;

public class LatestFuelPrice {

    public static void main(String args[]) throws IOException {
        print("====================BEGIN=======================");
        String configFile = args[0];
        Properties properties = new Properties();
        properties.load(new FileInputStream(configFile));

        XmlParser parser = new XmlParser(properties);
        String status = parser.process();

        Publisher publisher = new Publisher(status);
        publisher.init(properties);
        publisher.publish();
        print("==================== END =======================");
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

}

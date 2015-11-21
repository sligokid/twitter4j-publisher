package com.magoo.twitter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Publisher {

    private String status;

    private TwitterFactory twitterFactory;

    public Publisher(String status) {
        this.status = status;
    }

    public void init(Properties config) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(config.getProperty("oauth.consumerKey"))
                .setOAuthConsumerSecret(config.getProperty("oauth.consumerSecret"))
                .setOAuthAccessToken(config.getProperty("oauth.accessToken"))
                .setOAuthAccessTokenSecret(config.getProperty("oauth.accessTokenSecret"));
        this.twitterFactory = new TwitterFactory(cb.build());
    }

    public void publish() throws FileNotFoundException, IOException {
        Twitter twitter = twitterFactory.getInstance();
        try {
            Status result = twitter.updateStatus(status);
            System.out.println("Successfully updated the status to [" + result.getText() + "].");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}

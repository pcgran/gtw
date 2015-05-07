package com.gathertw.twitter;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterUtil {
	
	private ConfigurationBuilder cb;
	
	/**
	 * Constructor. Sets the parameters of the Twitter application in order to use it right after its creation.
	 */
	public TwitterUtil(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("Consumer Key")
	          .setOAuthConsumerSecret("Consumer Secret")
	          .setOAuthAccessToken("Access Token")
	          .setOAuthAccessTokenSecret("Token Secret");
	    this.cb = cb;
	}
	
	/**
	 * Returns a list of tweets that contain the keyword.
	 */
	public List<Status> getTweetsFromKeyWord(String keyword){
		TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
        try {
            Query query = new Query(keyword);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            
            return tweets;            
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        
        return null;
	}

}

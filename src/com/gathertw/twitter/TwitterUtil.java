package com.gathertw.twitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import com.gathertw.common.Constants;

/**
 * 
 * @author Pablo Conca Gran
 *
 */
public class TwitterUtil {

	private ConfigurationBuilder tweetConfiguration;
	private ConfigurationBuilder streamConfiguration;
	FileOutputStream tweetFile;
	List<Status> tweetList;

	/**
	 * Constructor. Sets the parameters of the Twitter application in order to
	 * use it right after its creation.
	 */
	public TwitterUtil() {
		ConfigurationBuilder tweetConfiguration = new ConfigurationBuilder();
		tweetConfiguration.setDebugEnabled(true)
				.setOAuthConsumerKey(Constants.CONSUMER_KEY)
				.setOAuthConsumerSecret(Constants.CONSUMER_SECRET)
				.setOAuthAccessToken(Constants.ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(Constants.ACCESS_TOKEN_SECRET);
		this.tweetConfiguration = tweetConfiguration;

		ConfigurationBuilder streamConfiguration = new ConfigurationBuilder();
		streamConfiguration.setDebugEnabled(true)
				.setOAuthConsumerKey(Constants.CONSUMER_KEY)
				.setOAuthConsumerSecret(Constants.CONSUMER_SECRET)
				.setOAuthAccessToken(Constants.ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(Constants.ACCESS_TOKEN_SECRET);
		streamConfiguration.setJSONStoreEnabled(true);
		streamConfiguration.setPrettyDebugEnabled(true);
		this.streamConfiguration = streamConfiguration;
		this.tweetList = new ArrayList<Status>();
	}

	/**
	 * Returns a list of tweets that contain the keyword.
	 */
	public List<Status> getTweetsFromKeyWord(String keyword) {
		TwitterFactory tf = new TwitterFactory(tweetConfiguration.build());
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

	/**
	 * Takes the tweets from a stream and stores it on a json file.
	 */
	public void storeTweetsFromStream(String q, String lang) {
		
		StatusListener listener = new StatusListener() {
			
			// this method is called every time a tweet comes in.
			public void onStatus(Status status) {
				System.out.println(status.getUser().getName() + " : " + status.getText());
				tweetList.add(status);
				// tweetFile.write(DataObjectFactory.getRawJSON(status).getBytes());
			}

			public void onDeletionNotice(
					StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			public void onScrubGeo(long arg0, long arg1) {
			}

			public void onStallWarning(StallWarning arg0) {
			}
		};

		TwitterStreamFactory tsf = new TwitterStreamFactory(streamConfiguration.build());
		TwitterStream twitterStream = tsf.getInstance();

		twitterStream.addListener(listener);

		FilterQuery query = new FilterQuery();
		String[] keywords = { q };
		String[] languages = { lang };

		query.track(keywords);
		query.language(languages);
		
		twitterStream.filter(query);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		twitterStream.shutdown();
	}

	/**
	 * Iterates the list of tweets and copies it into a json file
	 */
	@SuppressWarnings("deprecation")
	public void saveTweetsToFile(){
		for (int i = 0; i < tweetList.size(); i++) {
			//System.out.println(tweetList.get(i).toString());
			String tweetString = DataObjectFactory.getRawJSON(tweetList.get(i));
			String fileName = "/home/pablo/Downloads/output2.json";
			appendJSON(fileName, tweetString);
		}
	}
	
	//TODO los guarda todos pero no sobreescribe el archivo
	public static void appendJSON(String file, String json){
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
		    out.println(json);
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}

	/**
	 * Returns the list of tweets (Status objects).
	 */
	public List<Status> getTweetList() {
		return tweetList;
	}
	
	
}

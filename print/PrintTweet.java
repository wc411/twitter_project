package block3projectP1.print;

import java.util.Date;
import java.util.HashMap;
import twitter4j.Status;

/**
 * @author Krypton
 */
public class PrintTweet {
    
    //A single class with all the console display messages
    
    public void printStatus(Status tweet) {
        //Get information about the tweet
        String userName = tweet.getUser().getName();
        Date creationDate = tweet.getCreatedAt();
        String tweetText = tweet.getText();

        //Print out the information
        System.out.println("Tweet created by " + userName + " on date " + creationDate);
        System.out.println("Tweet text " + tweetText + "\n");
    }

    public void printTweetWords(HashMap<String, Integer> map) {
        //Displays the amount of time each word appeared
        for (String key : map.keySet()) {
            System.out.println("The word \"" + key + "\" was counted: " + map.get(key) + " times.");
        }
        //Displays the total amount of words found
        System.out.println("The amount of words found: " + map.size() + "\n");
    }

    public void printTweetIDs(HashMap<Long, Boolean> map) {
        //Displays the total amount tweets downloaded
        System.out.println(map.size() + " unique tweets downloaded.\n");
    }
    
    public void printTopTenWords(HashMap<String, Integer> map) {
        //Displays the top ten words from a query search
        for (String key : map.keySet()) {
            System.out.println("The word \"" + key + "\" was found " + map.get(key) + " times.");
        }
    }
}

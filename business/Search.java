package block3projectP1.business;

import block3projectP1.connect.CustomeQuery;
import block3projectP1.connect.TwitterConnect;
import block3projectP1.print.PrintTweet;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * @author Krypton
 */

public class Search {
    
    //A very basic twitter search example
    public void search(String search) {
        //Creates a connection with tweeter
        TwitterConnect twitter = new TwitterConnect();
        
        //Create a new instance of the printTweet class
        PrintTweet printTweet = new PrintTweet();
        
        //Create a new instance of the CustomeQuery class
        CustomeQuery querySearch = new CustomeQuery();
        
        //Buildes the query with the search input
        Query query = querySearch.search(search);
        
        //Execute the query
        QueryResult result;
        try {
            //Get the query results and stores it in this variable called result
            result = twitter.getTwitter().search(query);

            //Get the results
            List<Status> tweets = result.getTweets();

            //Print out the results
            for (Status tweet : tweets) {
                printTweet.printStatus(tweet);
            }
        } catch (TwitterException ex) {
            ex.printStackTrace();
        }
    }
}

package block3projectP1.business;

import block3projectP1.print.PrintTweet;
import block3projectP1.connect.CustomeQuery;
import block3projectP1.connect.TwitterConnect;
import java.util.HashMap;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * @author Krypton
 */
public class TimeLineSearch {

    //A HashMap to keep track the amount of times each word occurs.
    HashMap<String, Integer> wordGetter = new HashMap();

    //A HashMap to contain the top ten words from the query search
    private HashMap<String, Integer> top10 = new HashMap();
    
    //A method that searches on twitter with the passed on string
    public void timeLineSearch(String search) {
        
        //Creates a connection with twitter
        TwitterConnect twitter = new TwitterConnect();

        //Create a new instance of the splitWord class
        SplitWord split = new SplitWord();

        //Create a new instance of the FilterTopWords class
        FilterTopWords filterWords = new FilterTopWords();

        //Create a new instance of the printTweet class
        PrintTweet printTweet = new PrintTweet();

        //Create a new instance of the CustomeQuery class
        CustomeQuery querySearch = new CustomeQuery();

        //Buildes the query with the search input
        Query query = querySearch.search(search);

        //How many results do we want to retrieve
        int numResults = 500;

        //Filter out duplicate tweets and keep track of how many tweets we have downloaded
        HashMap<Long, Boolean> tweetIDMap = new HashMap();

        try {
            //Run query without max_id set
            QueryResult result = twitter.getTwitter().search(query);

            //Run query  until we have the required number of tweets or until there are no more tweets.
            while (result.getCount() > 0 && tweetIDMap.size() < numResults) {

                //Minimum ID of the returned results. Used to get sequence of tweets. See https://dev.twitter.com/rest/public/timelines
                long minID = -1;

                //Get the results
                List<Status> tweets = result.getTweets();

                //Work through the results
                for (Status tweet : tweets) {
                    
                    //Get the the tweet text from tweet results and stores it in this variable
                    String tweetTxt = tweet.getText();

                    //Track min id so we can get the next 'page'
                    if (minID == -1 || tweet.getId() < minID) {
                        minID = tweet.getId();
                    }

                    //Store ID in hash map to keep track of number of tweets
                    tweetIDMap.put(tweet.getId(), Boolean.TRUE);

                    //Creates a new hashmap for every loop
                    //Sends the tweet text to the other class split  word
                    //in return receive a hashmap with the amount of words and occurence times
                    HashMap<String, Integer> tempMap = new HashMap(split.WordSplit(tweetTxt));

                    //Takes the temp hashmap key and value and saves it in the actual wordGetter
                    for (String key : tempMap.keySet()) {
                        wordGetter.put(key, tempMap.get(key));
                    }
                }

                //Set the query to the minimum ID of the previous search minus 1
                query.setMaxId(minID - 1);

                //Run the search again
                result = twitter.getTwitter().search(query);
            }

            //Get the ten top words from the hashmap "wordGetter"
            top10 = filterWords.topWords(wordGetter);
            
            //Prints the ten top words
            printTweet.printTopTenWords(top10);
            
            //Displays the amount of time each word appeared and total amount of words found
            //printTweet.printTweetWords(wordGetter);
            
            //Displays the total amount tweets downloaded
            printTweet.printTweetIDs(tweetIDMap);

        } catch (TwitterException ex) {
            ex.printStackTrace();
        }
    }
    
    //A getter method that returns a HashMap list containing words and
    //their amount of frequency
    public HashMap<String, Integer> getList() {
        
        //Returns the top ten frequenced words
        return top10;

        //Returns the whole query list of words
        //return wordGetter;
    }
}

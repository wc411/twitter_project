package block3projectP1.connect;

import twitter4j.Query;
/**
 * @author Krypton
 */

//A query class to seperate the operation to it own class
public class CustomeQuery {
    
    public Query search(String search) {
        
        //Build query. Types of search listed here: https://dev.twitter.com/rest/public/search
        Query query = new Query(search);

        //Number of results pulled each time
        query.setCount(100);

        //Set the language of the tweets that we want 
        query.setLang("en");//Language codes listed here: https://en.wikipedia.org/wiki/ISO_639-1
        
        return query;
    }
}

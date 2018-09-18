package block3projectP1.connect;

import twitter4j.TwitterFactory;
import twitter4j.Twitter;

/**
 * @author Krypton
 */

//A class that connects to twitter with the configuration class
public class TwitterConnect {

    //Create a new instance of the AuthSetUp class
    AuthSetUp setUp = new AuthSetUp();

    //Create a new instance of Twitter with the configuration class
    TwitterFactory twitterFactory = new TwitterFactory(setUp.configBuilder.build());
    
    //A twitter instance with the configured build
    Twitter twitter = twitterFactory.getInstance();

    //A getter method to get the instance
    public Twitter getTwitter() {
        return twitter;
    }
    
}

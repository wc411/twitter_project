package block3projectP1.connect;

import block3projectP1.connect.ConfigKeys;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Krypton
 */

//A class that sets the configuration builder up
public class AuthSetUp {

    //Setting up the user authentication 
    ConfigurationBuilder configBuilder = new ConfigurationBuilder();
    
    //Create a instance of the ConfigKeys class
    ConfigKeys keys = new ConfigKeys();
    
    //When class is initialized the keys and token will be set to the configuration builder
    public AuthSetUp() {
        configBuilder.setOAuthConsumerKey(keys.getOAuthConsumerKey());
        configBuilder.setOAuthConsumerSecret(keys.getOAuthConsumerSecret());
        configBuilder.setOAuthAccessToken(keys.getOAuthAccessToken());
        configBuilder.setOAuthAccessTokenSecret(keys.getOAuthAccessTokenSecret());
    }
    
}

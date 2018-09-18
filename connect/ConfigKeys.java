package block3projectP1.connect;

/**
 * @author Krypton
 */

//A class to hold the keys and secret in one place
public class ConfigKeys {
    
    //A private string variable that contains the secret consumer keys and tokens
    private final String OAuthConsumerKey, OAuthConsumerSecret, OAuthAccessToken, OAuthAccessTokenSecret;
    
    //Initializes the variables by adding this strings into them
    public ConfigKeys() {
        this.OAuthConsumerKey = "RQa9IxTku4ShhW0CWQgXSoAaF";
        this.OAuthConsumerSecret = "8s95BlXHIFPVFzHKZgSgnkKvHMtsXC81diexQ1KlHDvMyuhfWv";
        this.OAuthAccessToken = "2905177475-ACcj8VjpaDXEJDpQAjEzyZt926EmqIgUyWxyBOy";
        this.OAuthAccessTokenSecret = "UdIaLyW332ERsA1JNHomU5Cj1objkARJ5jnG1eHKOg7AS";
    }

    //Getter method for consumer key
    public String getOAuthConsumerKey() {
        return OAuthConsumerKey;
    }

    //Getter method for the consumer secret
    public String getOAuthConsumerSecret() {
        return OAuthConsumerSecret;
    }

    //Getter method for the access token
    public String getOAuthAccessToken() {
        return OAuthAccessToken;
    }

    //Getter method for the access token secret
    public String getOAuthAccessTokenSecret() {
        return OAuthAccessTokenSecret;
    }
}

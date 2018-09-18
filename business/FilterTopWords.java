package block3projectP1.business;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author Krypton
 */
public class FilterTopWords {
    
    //A variable that controls the amount of element added to the HashMap.
    private final int MAX_WORDS = 10;
    
    //Input is a HashMap and output is a HashMap
    //A filter that filters the top ten words
    //The max words can be adjusted manual if needed
    public HashMap<String, Integer> topWords(HashMap<String, Integer> map) {
        
        //A new map that will keep the new list of words
        HashMap<String, Integer> filteredWords = new HashMap();

        //A basic for-loop that keeps track of the max amount of words to store
        //into the filteredWord map
        for (int x = 0; x < MAX_WORDS; x++) {
            
            //A for-loop that gets the highest frequency word and stores it
            //into the new map filteredWord
            for (String key : map.keySet()) {
                
                //Check wether the key(String) value is equal to the max value in the map
                //We know the highest value, but we don't know the key
                //A way to get the key.
                if (map.get(key).equals(Collections.max(map.values()))) {
                    
                    //If the key(String) value matches the max value,
                    //it stores the key and value into the new filteredWords map
                    filteredWords.put(key, map.get(key));
                    
                    //A break clause to break out from the second for-loop
                    break;
                }
            }
            //When broken out of the for-loop and added the key and value
            //It removes the max value including the key from the map
            //and it iterates over again until it's reached the max value
            map.values().remove(Collections.max(map.values()));
        }
        
        //Returnes the new map with the max size of words.
        return filteredWords;
    }
}

package block3projectP1.business;

import java.util.HashMap;

/**
 * @author Krypton
 */
public class SplitWord {

    //A HashMap containing words and their frequency
    private HashMap<String, Integer> words = new HashMap<String, Integer>();

    //A variable that controls the length of a word
    private final int MAX_STRING_LENGTH = 1;

    public HashMap<String, Integer> WordSplit(String tweetText) {

        //Change the tweet text into lower case
        tweetText = tweetText.toLowerCase();

        //Splits the tweet text into array of words
        String[] wordSplitted = tweetText.split("\\s+");

        //Counts the amount of time the same words appears
        //Else store it in the hashmap with the string as a value and count as the key
        for (String txt : wordSplitted) {

            //Removing all leading punctionation
            txt = txt.replaceAll("^[^a-zA-Z]+", "");
            
            //Removing all trailing punctionation
            txt = txt.replaceAll("[^a-zA-Z]+$", "");
            
            // Removing all hypertext links
            txt = txt.replaceAll("https?://\\S+\\s?", "");

            //A counter to keep track of the frequency of each word
            int count = 1;
            
            //If the length of the word is larger than the MAX_STRING_LENGTH stores it
            //else do nothing
            if (txt.length() > MAX_STRING_LENGTH) {
                
                //Check if the word is already in the HashMap
                if (words.containsKey(txt)) {
                    
                    //If the word is in the HashMap, get their current count
                    count = words.get(txt);
                    
                    //Replace the word with itself and add the new count that has been incremented
                    words.replace(txt, ++count);
                    
                  //Else if the word is not in the HashMap, add it, with the count value 1
                } else {
                    words.put(txt, count);
                }
            }
        }
        
        //A method that removes a certain type of words and the return type
        //is a new HashMap
        words = cleanWordMap(words);
        
        //Return the HashMap
        return words;
    }
    
    //A private method that removes a certain type of words in the HashMap
    //Input is a HashMap and output is a HashMap
    private HashMap<String, Integer> cleanWordMap (HashMap<String, Integer> map) {
        
        //A list of chosen words that should be removed
        //They must be manual added
        map.remove("the");
        map.remove("to");
        map.remove("a");
        map.remove("of");
        map.remove("not");
        map.remove("on");
        map.remove("but");
        map.remove("this");
        map.remove("it");
        map.remove("think");
        map.remove("from");
        map.remove("all");
        map.remove("it's");
        map.remove("feel");
        map.remove("am");
        map.remove("by");
        map.remove("so");
        map.remove("seen");
        map.remove("your");
        map.remove("don't");
        map.remove("get");
        map.remove("about");
        map.remove("char");
        map.remove("was");
        map.remove("our");
        map.remove("these");
        map.remove("do");
        map.remove("their");
        map.remove("if");
        map.remove("just");
        map.remove("at");
        map.remove("i'm");
        map.remove("still");
        map.remove("what");
        map.remove("when");
        map.remove("will");
        map.remove("go");
        map.remove("and");
        map.remove("i");
        map.remove("in");
        map.remove("have");
        map.remove("are");
        map.remove("for");
        map.remove("is");
        map.remove("the");
        map.remove("that");
        map.remove("me");
        map.remove("be");
        map.remove("with");
        map.remove("like");
        map.remove("as");
        map.remove("https");
        map.remove("they");
        map.remove("who");
        map.remove("you");
        map.remove("my");
        map.remove("out");
        map.remove("we");
        map.remove("");
        map.remove("rt");
        map.remove("more");
        
        //Returns the map
        return map;
    }
}

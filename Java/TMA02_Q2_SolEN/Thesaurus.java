import java.util.HashMap;
import java.util.HashSet;

/**
 * Question 2a
 * 
 * Models a real-world Thesaurus.
 * Each entry contains a sequence of synonyms for that word.
 * For example, if the looked-up word is happy, the corresponding
 * sequence of synonyms is "joyful", "contented", "cheerful".
 * New entries can be added, as can new synonyms for existing entries.
 * Alternative sentences can be formed using words that exist in
 * this Thesaurus and have synonyms available.
 * New entries can be made by cross referencing existing entries.
 *
 * @author Edward Nickless
 * @version 1 March 2022
 */
public class Thesaurus
{
    //Question 2b
    private HashMap<String, HashSet<String>> synonyms;
    
    /**
     * Question 2c
     * 
     * Constructor for objects of class Thesaurus.
     */
    public Thesaurus()
    {
        synonyms = new HashMap<>();
    }
    
    /**
     * Question 2d
     * 
     * Return the Thesaurus as a HashMap object.
     * 
     * @return This Thesaurus.
     */
    public HashMap<String, HashSet<String>> getThesaurus()
    {
        return synonyms;
    }
    
    /**
     * Question 2e
     * 
     * Populates this Thesaurus with the following sample entries:
     * happy - joyful contented cheerful
     * angry - annoyed vexed
     */
    public void populate()
    {
        HashSet<String> happySynonyms = new HashSet<>();
        HashSet<String> angrySynonyms = new HashSet<>();
        
        happySynonyms.add("joyful");
        happySynonyms.add("contented");
        happySynonyms.add("cheerful");
        synonyms.put("happy", happySynonyms);
        
        angrySynonyms.add("annoyed");
        angrySynonyms.add("vexed");
        synonyms.put("angry", angrySynonyms);
    }
    
    /**
     * Question 2f
     * 
     * Prints the current state of this Thesaurus to the terminal
     * in the format shown in the populate method comment.
     * Each key in the HashMap is printed followed by " - " and
     * the values for that key.
     */
    public void print()
    {
        HashSet<String> keySet = new HashSet<>(synonyms.keySet());
        for(String key : synonyms.keySet()) {
            //Print the HashMap Key
            System.out.print(key + " - ");
            //Print the synonyms associated with the Key
            HashSet<String> matchingSynonyms = new HashSet<>(synonyms.get(key));
            for(String aSynonym : matchingSynonyms) {
                System.out.print(aSynonym + " ");
            }
            //Move to the next line before printing the next Key
            System.out.println();
        }
    }
    
    /**
     * Question 2g
     * 
     * Adds a [word - synonym] pair to this Thesaurus.
     * If this Thesaurus already contains the given word,
     * the synonym is added to the existing entry. Otherwise,
     * a new entry is created for the [word - synonym] pair.
     * 
     * @param aWord The word to be added
     * @param aSynonym The synonym to be added
     */
    public void addSynonym(String aWord, String aSynonym)
    {
        //Adds a synonym to an existing entry
        if(synonyms.containsKey(aWord)) {
            HashSet<String> tempSet = new HashSet<>(synonyms.get(aWord));
            tempSet.add(aSynonym);
            synonyms.put(aWord, tempSet);
        }
        //Creates a new Key-Value pair in the Thesaurus
        else {
            HashSet<String> tempSet = new HashSet<>();
            tempSet.add(aSynonym);
            synonyms.put(aWord, tempSet);
        }
    }
    
    /**
     * Question 2h
     * 
     * Prints variations of a given sentence, replacing
     * the given word with matching synonyms.
     * 
     * @param aWord The word to be replaced
     * @param aSentence The sentence from which a variation can be constructed
     */
    public void replaceWord(String aWord, String aSentence)
    {
        HashSet<String> matchingSynonyms = new HashSet<>(synonyms.get(aWord));
        for(String aSynonym : matchingSynonyms) {
            System.out.println(aSentence.replace(aWord, aSynonym));
        }
    }
    
    /**
     * Question 2i
     * 
     * Cross references all existing entries and synonyms in
     * this Thesaurus. New [word - synonym] entries are added
     * based on existing entries.
     * For example, if the intial state is:
     *     happy - cheerful joyful
     * Then the state after calling this method will be:
     *     happy - cheerful joyful
     *     cheerful - happy joyful
     *     joyful - happy cheerful
     */
    public void crossReference()
    {
        //Create a separate, identical HashSet of HashMap Keys to iterate over
        HashSet<String> keySet = new HashSet<>(synonyms.keySet());
        for(String aKey : keySet) {
            //Create a separate, identical HashSet of HashMap Values to iterate over
            HashSet<String> currentValues = new HashSet<>(synonyms.get(aKey));
            for(String aWord : currentValues) {
                //Create a new temporary HashSet to add to the synonyms HashMap
                HashSet<String> newValues = new HashSet<>(currentValues);
                //Remove the current word from the HashSet to avoid duplicate synonyms
                newValues.remove(aWord);
                //Add the current HashMap Key to the temporary HashSet
                newValues.add(aKey);
                //Update this Thesaurus with the new [word - synonym] entry
                synonyms.put(aWord, newValues);
            }
        }
    }
}
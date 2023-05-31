import java.util.*;
/**
 * class RaceOrganiser models information
 * used by a race officer at a sailing club.
 *
 * @author M250 module team
 * @version v1
 */
public class RaceOrganiser
{
    //Question 2(d)(i)
    private ArrayList<Dinghy> racers;
    
    /**
     * Constructor for objects of class RaceOrganiser.
     * Creates an empty ArrayList holding instances of
     * class Dinghy or of subclasses of Dinghy.
     * 
     * @author Edward Nickless
     * @version 02.05.2022
     */
    public RaceOrganiser()
    {
        racers = new ArrayList<Dinghy>();
    }
    
    /**
     * Question 2(d)(ii)
     * 
     * Adds the given Dinghy object to the racers list
     * if it is not already in the racers list.
     * 
     * @param aRacer an instance of class Dinghy or of
     * a sublacss of Dinghy.
     * 
     * @author Edward Nickless
     * @version 02.05.2022
     */
    public void addRacer(Dinghy aRacer)
    {
        if(!racers.contains(aRacer)) {
            racers.add(aRacer);
        }
        else {
            System.out.println("The dinghy " + aRacer.getBoatName() +
                               " is already entered in the race"); 
        }
    }
    
    /**
     * Question 2(d)(iii)
     * 
     * Prints a formatted table of the list of dinghies
     * entered into the race. Details the name, boat class
     * and sail number of each dinghy.
     * 
     * @author Edward Nickless
     * @version 02.05.2022
     */
    public void printRacers()
    {
        //Create a copy of racers and sort alphabetically
        ArrayList<Dinghy> raceList = new ArrayList<Dinghy>();
        raceList.addAll(0, racers);
        Collections.sort(raceList);
        //Print table header
        System.out.printf("%-15s %-10s %-4s\n\n", "Dinghy name ", "Class ", "Sail number ");
        //Iterate through raceList and print details of each boat
        for(Dinghy aBoat : raceList) {
            System.out.printf("%-15s %-10s %-4s\n", 
            aBoat.getBoatName(), aBoat.getClassName(), aBoat.getSailNumber());
        }
    }
    
    /**
     * method to clear the racers list
     */
    public void clear()
    {
        racers.clear();
    }
    
    /**
      * @returns the size of the racers collection
      */
    public int getRacersSize()
    {
        return racers.size();
    }
}
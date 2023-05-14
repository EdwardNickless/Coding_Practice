import java.util.*;

/**
 * A ThemePark has a list of Rides.
 * Rides can be added to the theme park.
 * A String representation of a ThemePark can be displayed.
 * 
 * @author M250 Module Team
 * @version v1
 */
public class ThemePark
{
   private ArrayList<Ride> rides;

   /**
    * This constructor for objects of class ThemePark
    * initialises its rides list to an empty list.
    */
   public ThemePark()
   {
      rides = new ArrayList<>();
   }
   
   /**
    * Add a ride to the theme park.
    * 
    * @param aRide references a ride to be added to the ThemePark.
    */
   public void addRide(Ride aRide)
   {
      rides.add(aRide);
   }
   
   /**
    * Returns a String representation of all the rides in the ThemePark
    * @return the string representation of this ThemePark.
    */
   public String toString()
   {
      StringBuilder outputString = new StringBuilder();
      
      for (Ride aRide: rides){
         outputString.append(aRide.toString()).append("\n");         
      }
      
      return outputString.toString();
   }
   
   /**
    * Display the string representation of this ThemePark.
    */
   public void display()
   {
      System.out.println(this);
   }   
}
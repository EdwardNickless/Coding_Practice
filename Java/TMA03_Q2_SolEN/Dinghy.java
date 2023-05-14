/**
 * Class Dinghy simulates dinghies entered into a sailing race.
 *
 * @author M250 Module Team
 * @version v1
 */
//Question 2(c)(i)
//@author Edward Nickless
//version 26.04.2022
public abstract class Dinghy implements Comparable<Dinghy>
{
    private String className;
    private String boatName;
    private int sailNumber;

    /**
     * Constructor for abstract class Dinghy
     * @param aClassName The class of the dinghy (e.g. Laser)
     * @param aBoatName The boatName of the dinghy
     * @param aSailNumber The sail number of the dinghy
     * sets the fields className, boatName and sailNumber to those of the provided parameters
     */
    public Dinghy(String aClassName, String aBoatName, int aSailNumber)
    {
        boatName = aBoatName;
        className = aClassName;
        sailNumber = aSailNumber;
    }

    /**
     * Getter for the sailing class name of the dinghy.
     * @return The dinghy class name.
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * Getter for the boat's name.
     * @return the boat name of the dinghy.
     */
    public String getBoatName()
    {
        return boatName;
    }

    /**
     * Getter for the sail number of the dinghy.
     * @return the sail number of the dinghy
     */
    public int getSailNumber()
    {
        return sailNumber;
    }  

    /**
     * Get a string representation of this object including its 
     * sailing class name, boat name and sail number.
     * @return a String representation of the dinghy.
     */
    @Override
    public String toString()
    {
        return " A " + className 
                + " sailing dinghy named: " + boatName 
                +", sail number " + sailNumber;
    }

    /**
     * Compare a received object with this object for equality based
     * on boat name and class name.
     * @param obj reference the object to be compared with this object.
     * @return true if the received object is a dinghy 
     * that has the same boat name and class name as this object.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Dinghy)
        {
            Dinghy d = (Dinghy) obj;

            return  boatName.equals(d.boatName) 
            && className.equals(d.className);
        }
        
        return false;
    }

    /**
     * HashCode for a Dinghy based on its boat name and class name.
     * @return the hashcode for this dinghy. 
     */    
    @Override
    public int hashCode()
    {
        return boatName.hashCode() * className.hashCode();
    }
    
    /**
     * Question 2(c)(ii)
     * 
     * Compares the boatName fields between a given Dinghy instance and this
     * instance of Dinghy.
     * Returns an integer based on whether this Dinghy's boatName field
     * is less than, equal to or greater than the given Dinghy's boatName field.
     * 
     * @param otherDinghy The object to be compared against.
     * @return int Returns -1 for less than, 0 for equal, 1 for greater than.
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    @Override
    public int compareTo(Dinghy otherDinghy)
    {
        return getBoatName().compareTo(otherDinghy.getBoatName());
    }
}
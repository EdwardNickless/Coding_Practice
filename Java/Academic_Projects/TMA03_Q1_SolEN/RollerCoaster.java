import java.util.Objects;

/**
 * Question 2(b)(i)
 * 
 * RollerCoaster is a class that abstracts the common features
 * of roller coasters at a theme park. RollerCoasters can have multiple cars
 * that can take a certain number of people in them (their capacity).
 * The total capacity is the number of cars multiplied by the capacity of each car.
 *
 * @author Edward Nickless
 * @version 26.04.2022
 */
public class RollerCoaster extends Ride
{
    private int numberOfCars;
    
    /**
     * Question 2(b)(ii)
     * 
     * Constructor for objects of class Rollercoaster.
     * 
     * @param aName The name of the Rollercoaster.
     * @param aCarCapacity The capacity of a single car on the RollerCoaster.
     * @param aNumberOfCars The number of cars the RollerCoaster has.
     */
    public RollerCoaster(String aName, int aCarCapacity, int aNumberOfCars)
    {
        super(aName, aCarCapacity);
        numberOfCars = aNumberOfCars;
    }
    
    /**
     * Question 2(b)(iii)
     * 
     * Returns the total capacity of the RollerCoaster.
     * This is the numebr of cars multiplied by the capacity of each car.
     * 
     * @return The number of cars multiplied by the capacity of each car.
     */
    public int getCapacity()
    {
        return numberOfCars * getCarCapacity();
    }
    
    /**
     * Question 2(b)(iv)
     * 
     * Return a String representation of a RollerCoaster including
     * its class name and total capacity.
     * 
     * @return the string representation of the RollerCoaster. 
     */
    @Override
    public String toString()
    {
        String outputString = super.toString();
        
        outputString += "\nThe total capacity of the ride is ";
        outputString += getCapacity() + ".";
        
        return outputString;
    }
    
    /**
     * Question 1(b)(v)
     * 
     * Overrides the equals method inherited from class Ride.
     * True if the ride name and total capacity are equal to this
     * object's, otherwise returns false. For the purpose of
     * this method, instances of subclasses are considered equal.
     * 
     * @param Object An object to be compared against this RollerCoaster instance.
     * 
     * @return boolean True if the ride name and car capacity are
     * equal to this object's, otherwise returns false.
     */
     @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof RollerCoaster) {
            RollerCoaster anotherRollerCoaster = (RollerCoaster) obj;
            return getName().equals(anotherRollerCoaster.getName())
                    && getCapacity() == anotherRollerCoaster.getCapacity();
        }
        return false;
    }
    
    /**
     * Question 2(b)(vi)
     * 
     * Overrides the hashCode method inherited from Ride.
     * Returns a hashcode using the hash method from class Objects.
     * 
     * @return a hashcode generated using the hash method from class Objects
     *         with the values of the ride name and total capacity.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getName(), getCapacity());
    }
}
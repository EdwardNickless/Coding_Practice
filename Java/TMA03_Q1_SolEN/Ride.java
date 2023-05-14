/** 
 * Ride is a class that abstracts the common features
 * of rides at a theme park. Rides have a single car that can
 * take a certain number of people in them (their capacity).
 * 
 * @author M250 Module Team
 * @version v1
 */
public class Ride
{
    private String name;  
    private int carCapacity;
    private boolean operational;
    
    /**
     * Question 1(a)(i)
     * 
     * Constructor for objects of class Ride.
     * 
     * @param aName The name of the ride.
     * @param aCarCapacity The capacity of a single car on the ride.
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    public Ride(String aName, int aCarCapacity)
    {
        name = aName;
        carCapacity = aCarCapacity;
        operational = false;
    }

    /**
     * Question 1(a)(ii)
     * 
     * Overrides the equals method inherited from class Object.
     * True if the ride name and car capacity are equal to this
     * object's, otherwise returns false. For the purpose of
     * this method, objects of a subclass of Ride are not equal.
     * 
     * @param Object An object to be compared against this Ride instance.
     * 
     * @return boolean True if the ride name and car capacity are
     * equal to this object's and is of the class Ride, otherwise returns false.
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj != null && this.getClass().equals(obj.getClass())) {
            Ride anotherRide = (Ride) obj;
            return name.equals(anotherRide.name)
                    && carCapacity == anotherRide.carCapacity;
        }
        return false;
    }
    
    /**
     * Question 1(a)(iii)
     * 
     * Overrides the hashCode method inherited from class Object.
     * 
     * @return The sum of this ride name's length and this ride's capacity.
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    @Override
    public int hashCode()
    {
        return getName().length() + getCarCapacity();
    }
    
    /**
     * Getter for the ride name.
     * @return The name of the ride
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for the ride name.
     * @param the ride's name
     */
    public void setName(String aName)
    {
        name = aName;
    }

    /**
     * Getter for the ride's car capacity.
     * @return The number of people a car can carry
     */
    public int getCarCapacity()
    {
        return carCapacity;
    }

    /**
     * Setter for the ride's car capacity.
     * @param aCapacity The capacity of a car on this ride
     */
    public void setCarCapacity(int aCapacity)
    {
        carCapacity = aCapacity;
    }  

    /**
     * Getter for the operational status of the ride.
     * @return the operational status of the ride
     */
    public boolean isOperational()
    {
        return operational;
    }

    /**
     * Setter for the operational status of this ride.
     * @param rideState true if operational, otherwise false
     */
    public void setOperational(boolean rideState)
    {
        operational = rideState;
    }    

    /**
     * Return a String representation of a Ride including
     * its class name, allowing for extension by subclasses.
     * @return the string representation of the ride 
     */
    @Override
    public String toString()
    {
        String outputString = String.format("%s %s has car capacity %d and",
                getClass().getSimpleName(), name, carCapacity);

        if (operational) {
            outputString += " is running.";
        }
        else {
            outputString += " is not running.";
        }

        return outputString;
    }       
}
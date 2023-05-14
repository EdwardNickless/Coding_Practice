/**
 * Question 3(b)(i)
 * 
 * Class car models real world cars
 * that are owned by the rental company.
 *
 * @author Edward Nickless
 * @version 02.05.2022
 */
public class Car implements Comparable<Car>
{
    //Instance fields to hold the current details of this Car
    private String brand;
    private String model;
    private boolean isAvailable;
    private double cost;

    /**
     * Constructor for objects of class Car.
     * Sets this Car instances fields to the given values.
     * @param aBrand sets the brand of this Car instance.
     * @param aModel sets the model of this Car instance.
     * @param aCost sets the cost of renting this Car instance.
     */
    public Car(String aBrand, String aModel, double aCost)
    {
        brand = aBrand;
        model = aModel;
        cost = aCost;
        isAvailable = true;
    }
    
    /**
     * Sets this Car's isAvailable field to true or false
     * depending on the given value.
     * @param available A boolean used to set isAvailable to true or false.
     */
    public void setAvailability(boolean available)
    {
        isAvailable = available;
    }

    /**
     * Returns the brand of the car.
     * @return String The brand of this car.
     */
    public String getBrand()
    {
        return brand;
    }
    
    /**
     * Returns the model of the car.
     * @return String The model of this car.
     */
    public String getModel()
    {
        return model;
    }
    
    /**
     * Returns the cost of renting this car.
     * @return double The cost of renting this car.
     */
    public double getCost()
    {
        return cost;
    }
    
    /**
     * Returns whether or not this Car is available.
     * @ return boolean True if this Car is currently available,
     *                  otherwise returns false.
     */
    public boolean currentlyAvailable()
    {
        return isAvailable;
    }
    
    //All code and comments below this line answer Question 3(b)(ii)
    /**
     * Generates a human readable String representation of this Car instance.
     */
    @Override
    public String toString()
    {
        String outputString = getBrand() + " " + getModel();
        outputString += ". This car costs £" + getCost() + "0";
        if(isAvailable) {
            return outputString + " and is available.";
        }
        else {
            return outputString + " but is not available.";
        }
    }
    
    /**
     * Compare a received object with this object for equality based
     * on brand and model.
     * @param obj the object to be compared with this object.
     * @return true if the received object is a Car 
     * that has the same brand and model as this object.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Car)
        {
            Car c = (Car) obj;

            return  brand.equals(c.brand) 
            && model.equals(c.model);
        }
        
        return false;
    }
    
    /**
     * HashCode for a Car based on its brand and model.
     * @return the hashcode for this Car. 
     */    
    @Override
    public int hashCode()
    {
        return brand.hashCode() * model.hashCode();
    }
    
    /**
     * Compares the model fields between a given Car instance and this
     * Car instance.
     * Returns an integer based on whether this Cars cost field
     * is less than, equal to or greater than the given Car's cost field.
     * 
     * @param otherCar The object to be compared against.
     * @return int Returns -1 for less than, 0 for equal, 1 for greater than.
     */
    @Override
    public int compareTo(Car otherCar)
    {
        if(cost < otherCar.getCost()) {
            return -1;
        }
        else if(cost > otherCar.getCost()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
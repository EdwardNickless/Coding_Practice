import java.util.TreeSet;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Question 3(c)(i)
 * 
 * Garage models a real world garage owned by a car
 * rental company. The class includes methods for
 * adding or removing cars, removing every car at once,
 * updating details of cars, filtering the set of cars
 * and printing the details of each car in the entire Garage.
 *
 * @author Edward Nickless
 * @version 02.05.2022
 */
public class Garage
{
    // A set to store details of the cars owned by the garage
    private TreeSet<Car> cars;
    
    /**
     * Constructor for objects of class Garage.
     * Creates an empty TreeSet.
     */
    public Garage()
    {
        cars = new TreeSet<Car>();
    }
    
    /**
     * Clears the cars TreeSet.
     */
    public void clear()
    {
        cars.clear();
    }
    
    /**
     * Question 3(c)(ii)
     * 
     * Generates five example Car objects and adds them
     * to the cars TreeSet.
     */
    public void populate()
    {
        Car c1 = new Car("Ford", "Mondeo", 300.00);
        Car c2 = new Car("Audi", "A1", 200.00);
        Car c3 = new Car("BMW", "i8", 500.00);
        Car c4 = new Car("Mercedes Benz", "E320", 400.00);
        Car c5 = new Car("Nissan", "GTR", 750.00);
        
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);
    }
    
    /**
     * Question 3(c)(iii)
     * 
     * Writes the current list of cars to a CSV file.
     * The file will be created if an existing file of
     * the same name does not exist.
     * 
     * @param filename A String containing the filename to be written to.
     * @throws IOException
     */
    public void writeCSVFile(String filename) throws IOException
    {
        try(FileWriter writer = new FileWriter(filename)) {
            for(Car car : cars) {
                writer.write(car.getBrand() + ","
                             + car.getModel() + ","
                             + car.getCost());
                writer.write("\n");
            }
        }
        catch(IOException e) {
            System.err.print("There was an error while writing to the file " + filename);
        }
    }
    
    /**
     * Question 3(c)(iv)
     * 
     * Reads from a given CSV file line by line.
     * Generates a new instance of class Car for each line
     * and gets the paramaters, in order, from each
     * comma separated value.
     * 
     * @param filename The name of the CSV file to be read from.
     */
    public void readCSVFile(String filename) throws IOException
    {
        Charset charset = Charset.forName("ASCII");
        Path path = Paths.get(filename);
        
        try(BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = reader.readLine();
            while(line != null) {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(",");
                String aBrand = scanner.next();
                String aModel = scanner.next();
                double aCost = scanner.nextDouble();
                Car newCar = new Car(aBrand, aModel, aCost);
                cars.add(newCar);
                line = reader.readLine();
            }
        }
        catch(IOException e) {
            System.err.print("There was an error while reading from the file " + filename);
        }
    }
    
    //All code and comments below this line answer Question 3(d)
    /**
     * Adds a Car to the cars TreeSet if
     * it is not already present. Otherwise, prints an
     * error message including the brand and model of
     * which car could not be added.
     * 
     * @param aCar The instance of Car to be added to cars.
     */
    public void addMember(Car aCar)
    {
        if(!cars.contains(aCar)) {
            cars.add(aCar);
        }
        else {
            System.err.print("The " + aCar.getBrand()
                             + " " + aCar.getModel()
                             + " could not be added.");
        }
    }
    
    /**
     * Removes a Car from the cars TreeSet.
     * Returns true if successful, false if not successful.
     * 
     * @param aCar The model of the Car to be removed from cars.
     * @return boolean Whether the remove operation has been
     *                 successful or not.
     */
    public boolean removeMember(String aModel)
    {
        boolean successful = false;
        Car aCar = new Car("","",0.0);
        
        for(Car thisCar : cars) {
            if(aModel.equals(thisCar.getModel())) {
                aCar = thisCar;
            }
        }
        
        //Attempts to remove the Car from cars.
        if(cars.remove(aCar)) {
            successful = true;
        }
        
        return successful;
    }
    
    /**
     * Updates the availability for a given Car.
     * 
     * @param aModel The model of the Car for which the
     *               availability is to be set.
     * @param isAvailable Whether the Car is now
     *             available or unavailable.
     */
    public void updateMember(String aModel, boolean isAvailable)
    {
        Car aCar = new Car("","",0.0);
        
        for(Car thisCar : cars) {
            if(aModel.equals(thisCar.getModel())) {
                aCar = thisCar;
            }
        }
        
        aCar.setAvailability(isAvailable);
    }
    
    /**
     * Returns an ArrayList of available or unavailable Cars.
     * 
     * @param isAvailable boolean true for available, false for unavailable.
     */
    public ArrayList<Car> selectMembers(boolean isAvailable)
    {
        ArrayList<Car> carList = new ArrayList<Car>();
        for(Car aCar : cars) {
            if(aCar.currentlyAvailable() == isAvailable) {
                carList.add(aCar);
            }
        }
        
        return carList;
    }
    
    /**
     * Using a loop, prints the whole TreeSet of Cars,
     * one Car per line of output, stating the Brand, Model and Cost.
     * Prints a blank line after the last Car.
     */
    public void printMembers()
    {
        for(Car aCar : cars) {
            System.out.printf("%-15s %-10s",
                              aCar.getBrand(), aCar.getModel());
            System.out.printf("£%.2f", aCar.getCost());
            if(aCar.currentlyAvailable()) {
                System.out.print("  Available\n");
            }
            else {
                System.out.print("  Not available\n");
            }
        }
        System.out.println();
    }
}
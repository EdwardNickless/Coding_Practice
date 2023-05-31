
/**
 * Question 3a
 * 
 * Shows the spread of an infection in a school population
 * using a SIR Model. A SIR Model represents each person in
 * the poulation as being either Susceptible, Infected or Recovered.
 * The sum of all three sub-populations always adds up to be equal to
 * the total population.
 * The infection spread is shown using a printed graph displaying
 * how many people are infected on each day from day 0 to the final day.
 *
 * @author Edward Nickless
 * @version 2 March 2022
 */
public class SIRModel
{
    //Question 3b
    //Class constants
    private static final int POPULATION = 150,
                             INITIAL_INFECTIONS = 4,
                             DAYS = 60;
    //constants
    private final double TRANS_RATE,
                         REC_RATE;
    private double[] susceptible,
                     infected,
                     recovered;
    
    /**
     * Question 3c
     * 
     * Constructor for objects of class SIRModel.
     * 
     * @param transRate The double value used to intialise the TRANS_RATE field
     * @param recRate The double value used to intialise the REC_RATE field
     */
    public SIRModel(double transRate, double recRate)
    {
        //Initialise TRANS_RATE and REC_RATE with the given constructor parameters
        TRANS_RATE = transRate;
        REC_RATE = recRate;
        //Initialise susceptible, infected and recovered to new double arrays of length DAYS
        susceptible = new double[DAYS];
        infected = new double[DAYS];
        recovered = new double[DAYS];
        //Initialise the first element of infected with INITIAL_INFECTIONS
        infected[0] = INITIAL_INFECTIONS;
        //Initialise susceptible to the difference between POPULATION and INITIAL_INFECTIONS
        susceptible[0] = POPULATION - INITIAL_INFECTIONS;
    }
    
    /**
     * Question 3d
     * 
     * Calculates the expected number of newly infected people in
     * a day using a density-dependant model.
     * 
     * @param currentInfected The number of people currently infected
     * @param currentSusceptible The number of people currently susceptible to infection
     * @return The expected number of new infections in a day represented as a double
     */
    public double newlyInfected(double currentInfected, double currentSusceptible)
    {
        double valueToBeDivided = (TRANS_RATE * currentInfected * currentSusceptible);
        double valueDivided = valueToBeDivided / POPULATION;
        return valueDivided;
    }
    
    /**
     * Question 3e
     * 
     * Calculates the expected number of people to recover in a day
     * and returns this as a double.
     * 
     * @param currentInfected The number of currently infected people
     * @return The number of people expected to recover in a day
     */
    public double newlyRecovered(double currentInfected)
    {
        double newlyRecovered = REC_RATE * currentInfected;
        return newlyRecovered;
    }
    
    /**
     * Question 3f
     * 
     * Returns a positive or negative value represented as a double
     * depicting the change in the number of people expected to be
     * infected after a day has passed. The value is negative if the
     * number of daily infections is falling.
     * 
     * @param currentInfected The number of currently infected people
     * @param currentSusceptible The number of people currently susceptible to infection
     * @return The change in the number of people expected to be infected after a day
     */
    public double changeInInfected(double currentInfected, double currentSusceptible)
    {
        double newInfections = newlyInfected(currentInfected, currentSusceptible);
        double newRecoveries = newlyRecovered(currentInfected);
        double change = newInfections - newRecoveries;
        return change;
    }
    
    /**
     * Question 3g
     * 
     * Calculates the number of infected, recovered, and
     * susceptible people based on the previous day's data.
     * Assigns the calculated values to the respective double
     * arrays at the index of the current day.
     * 
     * @param prevDay The index of the previous day
     */
    public void nextDay(int prevDay)
    {
        //Calculate the number of infected people and assign it to the current day
        double newInfections = infected[prevDay]
                               + changeInInfected(infected[prevDay],susceptible[prevDay]);
        infected[prevDay + 1] = newInfections;
        //Calculate the number of recovered people and assign it to the current day
        double newRecoveries = recovered[prevDay]
                               + newlyRecovered(prevDay);
        recovered[prevDay + 1] = newRecoveries;
        //Calculate the number of susceptible people and assign it to the current day
        double stillSusceptible = POPULATION - (newInfections + newRecoveries);
        susceptible[prevDay + 1] = stillSusceptible;
    }
    
    /**
     * Question 3h
     * 
     * Generates a model of how the infection is spreading within
     * the school population. Each of the three arrays
     * infected, recovered, and susceptible will now be populated.
     */
    public void createData()
    {
        for(int i=0; i < DAYS - 1; i++) {
            nextDay(i);
        }
    }
    
    /**
     * Question 3i
     * 
     * Prints a graph representing the numebr of infected people
     * on each day.
     */
    public void printGraph()
    {
        for(int i=0; i < DAYS; i++) {
            int currentInfected = (int) Math.round(infected[i]);
            System.out.print(i + " ");
            for(int j=1; j <= currentInfected; j++) {
                System.out.print("*");
            }
            System.out.print(" (" + currentInfected + ")");
            System.out.println();
        }
    }
}

/**
 * Class ClubBoat simulates a Dinghy that is owned by a sailing club.
 *
 * @author M250 Module team
 * @version v1
 */
//Question 2(a)(i)
public class ClubBoat extends Dinghy
{
     private String memberId;
    
    /**
     * Question 2(a)(i)
     * 
     * Constructor for objects of class ClubBoat.
     * 
     * @param aClassName The class of the ClubBoat (e.g. Laser)
     * @param aBoatName The boatName of the ClubBoat
     * @param aSailNumber The sail number of the ClubBoat
     * 
     * sets the fields className, boatName and sailNumber to those of the provided parameters
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    public ClubBoat(String aClassName, String aBoatName, int aSailNumber)
    {
        super(aClassName, aBoatName, aSailNumber);
        memberId = "";
    }
    
    /**
     * Setter method for memberId.
     * @param anId An id for the member loaning the boat.
     */    
    public void setMemberId(String anId)
    {
        memberId = anId;
    }
    
    /**
     * Getter method for memberId.
     * @return the memberId of the person using this boat.
     */    
    public String getMemberId()
    {
        return memberId;
    }
    
    /**
     * Question 2(a)(ii)
     * 
     * Overrides the toString method inherited from class Dinghy.
     * Provides a meaningful string representation of this ClubBoats
     * current state.
     * 
     * @return string A meaningful representation of this objects current state.
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    @Override
    public String toString()
    {
        return super.toString() + ", Membership ID: " + getMemberId();
    }
    
    /**
     * Question 2(a)(iii)
     * 
     * Overrides the equals method inherited from class Dinghy.
     * Returns a boolean, false if not comapring two ClubBoat instances,
     * otherwise functions the same as the inherited equals method from Dinghy.
     * 
     * @param Object an object to be compared against this ClubBoat instance.
     * 
     * @return boolean False if not comparing two ClubBoat objects, otherwise
     *         returns true if className and boatName are equal.
     *         
     * @author Edward Nickless
     * @version 26.04.2022
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj != null && this.getClass().equals(obj.getClass())){
            return super.equals(obj);
        }
        return false;
    }
}
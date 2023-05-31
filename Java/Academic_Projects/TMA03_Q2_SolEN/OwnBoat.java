/**
 * Class OwnBoat simulates a Dinghy 
 * that is owned by a sailor who may be a 
 * visitor or a member of the club.
 *
 * @author M250 Module team
 * @version v1
 */
//Question 2(b)(i)
//@author Edward Nickless
//@version 26.04.2022
public class OwnBoat extends Dinghy
{
    private boolean visitor;
    
    /**
     * Question 2(b)(ii)
     * 
     * Constructor for objects of class OwnBoat.
     * 
     * @param aClassName The class of the OwnBoat (e.g. Laser)
     * @param aBoatName The boatName of the OwnBoat
     * @param aSailNumber The sail number of the OwnBoat
     * @param isAVisitor Whether the sailor is a visitor or a club member.
     * 
     * sets the fields className, boatName and sailNumber to those of the provided parameters.
     * sets the field visitor to true if the sailor is a member, otherwise
     * sets visitor to false
     * 
     * @author Edward Nickless
     * @version 26.04.2022
     */
    public OwnBoat(String aClassName, String aBoatName, int aSailNumber, boolean isAVisitor)
    {
        super(aClassName, aBoatName, aSailNumber);
        visitor = isAVisitor;
    }
    
    /**
     * setter method for visitor
     * @param aVisitor true if the owner is a visitor, otherwise false.
     */    
    public void setVisitor(boolean aVisitor)
    {
        visitor = aVisitor;
    }
    
    /**
     * Tells whether the boat is being used by a visitor the club.
     * @return visitor true if the owner is a visitor, otherwise false.
     */    
    public boolean isVisitor()
    {
        return visitor;
    }
    
    /**
     * Question 2(b)(iii)
     * 
     * Overrides the toString method inherited from class Dinghy.
     * Provides a meaningful string representation of this OwnBoats
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
        if(visitor) {
            return super.toString() + " sailed by a visitor to the club";
        }
        else {
            return super.toString() + " sailed by a club member";
        }
    }
    
    /**
     * Question 2(b)(iv)
     * 
     * Overrides the equals method inherited from class Dinghy.
     * Returns a boolean, false if not comapring two OwnBoat instances,
     * otherwise functions the same as the inherited equals method from Dinghy.
     * 
     * @param Object an object to be compared against this OwnBoat instance.
     * 
     * @return boolean False if not comparing two OwnBoat objects, otherwise
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
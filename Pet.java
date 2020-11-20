
/**
 * Pet Class Definition with constructors and methods that are used
 * in the Owner Class.
 *
 * @author Samuel Phillips
 * @version ITSC1213-FALL2018 11/7/18
 */
public class Pet
{
    //collection of private fields that are used to make a pet object
    private String pName;
    private String aType;
    private double weight;
    private String lRabies;
    private String lVisit;

    /**
     * No-args constructor method that sets all values to either null or 0.
     */
    public Pet()
    {
        //sets all strings to null & sets weight to 0
        pName = aType = lRabies = lVisit = null;
        weight = 0.0;

    }//end of no-args pet constructor

    /**
     * Constructor method that intakes parameter values and sets them as such 
     * for each field.
     * @param n is a new pet name, t is a new pet type, w is a new pet weight,
     * r is a new date that the pet last received their rabies shot and v is a
     * new date that the pet last visited the place.
     */  
    public Pet(String n, String t, double w, String r, String v)
    {
        //makes objects from the field above by using values from the parameter
        pName = new String(n);
        aType = new String(t);
        weight = w;
        lRabies = new String(r);
        lVisit = new String(v);

    }//end of Pet set constructor

    /**
     * Copy constructor method that makes a deep copy of a pet object.
     * @param newP is a pet object that uses an existing pet object
     * to make a deep copy.
     */  
    public Pet(Pet newP)
    {
        //uses an instance of a pet object to copy its fields to be like the
        //parameters' pet copy fields 
        this.pName = newP.pName;
        this.aType = newP.aType;
        this.weight = newP.weight;
        this.lRabies = newP.lRabies;
        this.lVisit = newP.lVisit;
    }//end of Pet copy constructor

    /**
     * ToString method that lists out the pet details in an ordered fashion.
     * @return a string statement of a pet object in an ordered way.
     */
    public String toString()
    {
        //returns a string statement of the details of the pet object in a neat
        //ordered fashion
        return "\nName of Pet: " + pName + "\n" +
        "Pet Type: " + aType + "\n" + "Pet Weight: " + weight + "\n" +
        "Last Rabies Shot: " + lRabies + "\n" + "Last Visit: " + lVisit + "\n";

    }//end of toString method

    /**
     * ToString like method that prints out the pet details in the original
     * format like on the clientdata.txt text file.
     * @return a string statment of a pet object in an old format way
     * like in the textfile.
     */
    public String toFileOut()
    {
        //returns a string statment of the details of the pet object in an
        //arrangement like on the original text file
        return pName + "," + aType + "," + weight + "," + lRabies + "," + lVisit;

    }//end of toFileOut method
}//end of Pet class

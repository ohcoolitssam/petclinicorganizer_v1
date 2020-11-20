
/**
 * Owner class definition that uses methods from the Pet class definition to
 * make methods that are used in the Driver.
 *
 * @author Samuel Phillips
 * @version ITSC1213-FALL2018 11/7/18
 */
public class Owner
{
    //collection of private fields used to make a Owner object
    private String lName;
    private String fName;
    private String address;
    private int ID;
    private int nVisits;
    private double oBalance;
    //a pet array based on the pet class is stated as some owners in the text
    //file have multiple pets
    private Pet[] pets;

    /**
     * No-args constructor method that sets all the values to null or zero.
     */
    public Owner()
    {
        //sets all string fields to null
        lName = fName = address = null;
        //sets all integers and doubles to 0
        ID = nVisits = 0;
        oBalance = 0.0;
        //states a pet array with no values
        Pet[] pets;

    }//end of no-args owner constructor

    /**
     * Constructor method that intakes values from the parameter that 
     * will be used to set the fields' values while also setting the pet 
     * array's length.
     * @param l is the last name of the owner, f is the first name of the owner,
     * a is the address of the owner, id is the ID of the owner, v is the number of visits
     * the owner has made to the pet place, b is the balance still due from the owner to
     * the pet place and numberOfPets is the total number of pets the Owner has.
     */
    public Owner(String l, String f, String a, int id, int v, double b, int numberOfPets)
    {
        //makes an owner object by intaking values from the parameter of 
        //this class
        lName = l;
        fName = f;
        address = a;
        ID = id;
        nVisits = v;
        oBalance = b;
        //also creates a pet array with a certain length via the
        //numberOfPets parameter
        pets = new Pet[numberOfPets];
    }//end of Owner set constructor with pet array length intake

    /**
     * Constructor method that intakes values from the parameter that
     * will be used to set the fields' values while also using an existing pet
     * array to set up a new one later in the method.
     * @param l is the last name of the owner, f is the first name of the owner,
     * a is the address of the owner, id is the ID of the owner, v is the number of visits
     * the owner has made to the pet place, b is the balance still due from the owner to
     * the pet place and [] inPets is another pet array that will be used as a guide.
     */
    public Owner(String l, String f, String a, int id, int v, double b, Pet [] inPets)
    {
        //makes an owner object by intaking values from the parameter of 
        //this class
        lName = l;
        fName = f;
        address = a;
        ID = id;
        nVisits = v;
        oBalance = b;
        //makes a new pet array by using the inPets length
        pets = new Pet[inPets.length];
        //for statement that also sets all pets in the pets array equal
        //to all the pets in the inPets array
        for(int k = 0; k < pets.length; k++)
        {
            pets[k] = inPets[k];
        }
    }//end of Owner set constructor with pet array intake

    /**
     * Copy constructor method that makes a deep copy of an Owner object.
     * @param n is an owner object that uses an existing owner object
     * to make a deep copy.
     */
    public Owner(Owner n)
    {
        //uses an instance of an owner object to copy its fields to be like the
        //parameters' owner copy fields 
        this.lName = n.lName;
        this.fName = n.fName;
        this.address = n.address;
        this.ID = n.ID;
        this.nVisits = n.nVisits;
        this.oBalance = n.oBalance;
        this.pets = n.pets;        
    }//end of Owner copy constructor

    /**
     * Get method that returns the number of pets in an array of pets.
     * @return an int is returned based off of the length of a pet array.
     */
    public int getNumPets()
    {
        //returns an integer that represents the number of pets in the array
        return pets.length;
    }//end of getNumPets method

    /**
     * Get method that returns a string representation of the first pet in
     * the pets array.
     * @return a string statement is returned based off of the pet in the first
     * spot of the array.
     */
    public String getPet1()
    {
        //returns a string representation of the first pet in the array
        //in a format like in the original textfile
        return pets[0].toFileOut();
    }//end of getPet1 method

    /**
     * Get method that returns a string representation of the second pet in
     * the pets array.
     * @return a string statement is returned based off of the pet in the second
     * spot of the array.
     */
    public String getPet2()
    {
        //returns a string representation of the second pet in the array
        //in a format like in the original textfile
        return pets[1].toFileOut();
    }//end of getPet2 method

    /**
     * Get method that returns a string representation of the third pet in
     * the pets array.
     * @return a string statement is returned based off of the pet in the third
     * spot of the array.
     */
    public String getPet3()
    {
        //returns a string representation of the third pet in the array
        //in a format like in the original textfile
        return pets[2].toFileOut();
    }//end of getPet3 method

    /**
     * Get method that returns a string representation of the fourth pet in
     * the pets array.
     * @return a string statement is returned based off of the pet in the fourth
     * spot of the array.
     */
    public String getPet4()
    {
        //returns a string representation of the fourth pet in the array
        //in a format like in the original textfile
        return pets[3].toFileOut();
    }//end of getPet4 method

    /**
     * Get method that intakes an integer and returns a string representation
     * of a certain pet from the pets array.
     * @return a string statement is returned based off of the pet in a certain
     * spot of the array.
     */
    public String getPets(int x)
    {
        //returns a string representation of a certain number pet in the pets
        //array in a format like the original textfile
        return pets[x].toFileOut();
    }//end of getPets method

    /**
     * Set method that intakes an integer from the parameter and sets the
     * nVisits field to that integer.
     * @param newVis represents a replacement value for the nVisits field.
     */
    public void setnVisits(int newVis)
    {
        //original value of the nVisits field is overwritten and replaced
        //with the newVis value
        nVisits = newVis; 

    }//end of setnVisits method

    /**
     * Get method that returns the number of vists.
     * @return the number of visits an owner has is returned.
     */
    public int getnVisits()
    {
        //returns the field nVisits' value
        return nVisits;
    }//end of getnVisits method

    /**
     * Set method that uses the double in the parameter to set a new value
     * for the field oBalance.
     * @param newBal represents a replacement value for the oBalance field.
     */
    public void setoBalance(double newBal)
    {
        //original oBalance value is replaced by the double newBal's value
        oBalance = newBal;

    }//end of setoBalance method

    /**
     * Get method that returns the balance due on the owner's account.
     * @return a value in the oBalance field is returned.
     */
    public double getoBalance()
    {
        //returns the field oBalance's value
        return oBalance;
    }//end of getoBalance method

    /**
     * Equals method that checks and sees if the ID of one Owner equals the 
     * ID of another owner.
     * @param n represents an owner object that will be compared to an existing
     * owner object in this method.
     * @return x - boolean; if true, both owner IDs are the same; if false
     * its otherwise.
     */
    public boolean equals(Owner n)
    {
        //boolean variable x is stated and is given the value of false
        boolean x = false;

        //if statement used to check if the ID of one Owner equals the ID
        // of the owner from the parameter
        //if it is true: x is set to true
        //if it false: x is set to false
        if ((this.ID) == (n.ID))
        {
            x = true;
        } else {
            x = false;
        }
        //method ends with the boolean x variable being returned
        return x;

    }//end of equals method

    /**
     * CompareTo method that comapres the first and last name of an Owner
     * to the first and last name of another owner from the parameter.
     * @param other represents another owner object that will be used to
     * be compared to an existing owner object via first and last names.
     * @return integer (1,-1,0); if 1,the original owner instance 
     * has a higher alphabet rank than the parameter owner; 
     * if -1, the parameter owner has a higher alphabet rank
     * than the original owner instance; 
     * if 0, both the original owner instance and
     * the parameter owner have the same alphabet rank.
     */
    public int compareTo(Owner other)
    {
        //returns an int based on whether one owner has a higher alphabet 
        //rank than the other
        return (this.lName + this.fName).compareTo(other.lName + other.fName); 

    }//end of compareTo method

    /**
     * ToString method that prints a string statement based off of the
     * finalized field details from the start in an ordered fashion.
     * @return a string statement is returned in an ordred way for presentation.
     */
    public String toString()
    {
        //a string statement is returned in an ordered fashion based off of the
        //field values from the start
        return "\nLast and First Name: " + lName + ", " + fName + "\n" +
        "Address: " + address + "\n" +
        "ID: " + ID + "\n" + "Number of Visits: " + nVisits + "\n" +
        "Balance Due: " + oBalance + " $" + "\n" + "Number of Pets: " + pets.length + "\n";

    }//end of toString method

    /**
     * ToFileOut method that prints a string statement based off of the
     * finalized field details from the start in a format like the
     * original text file.
     * @return a string statement is returned in a format like on the textfile.
     */
    public String toFileOut()
    {
        //a string statement is returned in a format like the on the original
        //textfile based off of finalized values from the start
        return lName + "," + fName + "," + address + "," + ID + "," + nVisits + "," + oBalance + "," + pets.length;

    }//end of toFileOut method
}//end of Owner class

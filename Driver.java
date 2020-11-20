//java util is imported for the scanner class and more
import java.util.*;
//java io is imported for the file class and more
import java.io.*;

/**
 * Driver that executes all the methods from the owner class and also
 * intakes a text file, reads it, and prints it to a new text file.
 *
 * @author Samuel Phillips
 * @version ITSC1213-FALL2018 11/7/18
 */
public class Driver
{
    public static void main (String [] args) throws IOException
    {
        //scanner object input is created so that the user can type values
        //in for menu control
        Scanner input = new Scanner(System.in);
        //integer numClients is used to decide the length of the myClients 
        //array
        int numClients;
        //stringtokenizer reference is made to sort textfile
        StringTokenizer stok;
        //chair choice reference is made for menu choice
        char choice;
        //owner tempholding reference is made to sort the myclients array
        Owner tempHolding;

        //bunch of owner class details that set up owner objects in the
        //my clients array
        Owner [] myClients;
        String inLast;
        String inFirst;
        String address;
        int inID;
        int inVisits;
        double inDue;
        int inPets;

        //bunch of pet class detials that set up pet objects in the pets array
        // of the myclients array
        Pet [] pets;
        String inName;
        String inType;
        double inWeight;
        String lastR;
        String lastV;

        //user is prompted to enter the path of the text file
        //file 'clientdata.txt' is always used but other files with the
        //same format can be used
        //a new scanner object named in is stated and the file that the user
        //typed in is used and opened
        System.out.println("Enter the path and name of the data file: ");
        Scanner in = new Scanner(new File(input.nextLine()));

        //numClients reference is given an int by using the first int
        //of the textfile
        numClients = in.nextInt();
        //new line from textfile is read in
        in.nextLine();
        //owner object array myclients is made with its length being stated by
        //the number of clients integer
        myClients = new Owner[numClients];

        //for loop is made to cycle through all the clients' lines of the text file
        for (int i = 0; i < myClients.length; i++)
        {
            //string tokenizer object is made taking in a line and tokenizes
            //using commas as delimiters
            stok = new StringTokenizer(in.nextLine(), ",");

            //all tokens of the line are taken in as values for the owner fields 
            //from the start
            //as well as a pets array being made based on the final token of the line
            inLast = stok.nextToken();
            inFirst = stok.nextToken();
            address = stok.nextToken();
            inID = Integer.parseInt(stok.nextToken());
            inVisits = Integer.parseInt(stok.nextToken());
            inDue = Double.parseDouble(stok.nextToken());
            inPets = Integer.parseInt(stok.nextToken());
            pets = new Pet[inPets];

            //for loop is made to cycle through the lines after each owner line
            //in the text file
            for (int k = 0; k < pets.length; k++)
            {
                //string tokenizer object is made again taking in a line and
                //tokenizes using commas as delimiters
                stok = new StringTokenizer(in.nextLine(), ",");
                //all tokens of the line are taken in as values for the pet fields
                //from the start
                //as well as pet objects being made for each spot in the pet array
                //for each client
                inName = stok.nextToken();
                inType = stok.nextToken();
                inWeight = Double.parseDouble(stok.nextToken());
                lastR = stok.nextToken();
                lastV = stok.nextToken();
                pets[k] = new Pet(inName, inType, inWeight, lastR, lastV);

            }

            //owner array is finalized with all the details from above
            myClients[i] = new Owner(inLast, inFirst, address, inID, inVisits, inDue, pets);

        }

        //user is given all the clients' information using a for loop
        System.out.println("\nHere are the Clients unsorted: ");
        for (int w = 0; w < myClients.length; w++)
        {
            System.out.println(myClients[w] + " ");
        }

        //do/while statement is used so the user can get back to the main menu
        do {
            //user is presented with a menu with options in which they can enter
            //letters to choose those options via the input scanner class
            System.out.println("\nChoose an option to do: " +
                "\nA: Print out Clients in sorted order." +
                "\nB: Find a specific Client." +
                "\nC: Save the changes made into a new text file.");
            choice = input.next().charAt(0);

            //if the user types in a, the myclients array is sorted via for loops
            //and then is printed out in an ordered fashion using another for loop
            if (choice == 'a' || choice == 'A')
            {
                for (int x = 0; x < myClients.length -1; x++)
                {
                    for(int y = x + 1; y < myClients.length; y++)
                    {
                        if(myClients[x].compareTo(myClients[y])>0)
                        {
                            tempHolding = myClients[x];
                            myClients[x] = myClients[y];
                            myClients[y] = tempHolding;
                        }
                    }
                }

                System.out.println("\nHere are the clients sorted alphabetically by last name: ");
                for (int z = 0; z < myClients.length; z++)
                {
                    System.out.println(myClients[z] + " ");
                }

              //if the user types in b, then they are presented with an option to
              //choose whether they have already sorted or whether they have not
            } else if (choice == 'b' || choice == 'B')
            {
                System.out.println("\nHave you already sorted your clients?");
                System.out.println("\nType 'y' or 'Y' for yes and 'n' or 'N' for no: ");

                choice = input.next().charAt(0);
                //if their choice is no, then the clients are stated in an
                //unordered fashion
                if (choice == 'n' || choice == 'N')
                {

                    //the user is prompted with an option to enter an id of a client
                    System.out.println("\nEnter a clients ID to alter: ");
                    System.out.println("\nHere is a selection of our unsorted clients' IDs: " +
                        "\nMorely (15396)" +
                        "\nWilder (78214)" +
                        "\nMiller (96258)" +
                        "\nJones (47196)" +
                        "\nSmith (67125)" +
                        "\nWard (22234)" +
                        "\nMercury (21312)");
                    int enterID = input.nextInt();
                    //here are a bunch of if statements for each id
                    //when entering each id, the user is given a menu to choose from
                    //a lets you change the balance of the specific client
                    //b lets you change the client's number of visits
                    //c lets you list out the client's pets
                    
                    //id for robert morely
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 15396)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[0].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[0].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[0].getnVisits());
                            int v = input.nextInt();
                            myClients[0].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[0].getPet1());
                            System.out.println(myClients[0].getPet2());
                        }
                    }

                    //id for john wilder
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 78214)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[1].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[1].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[1].getnVisits());
                            int v = input.nextInt();
                            myClients[1].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[1].getPet1());

                        }
                    }

                    //id for john miller
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 96258)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[2].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[2].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[2].getnVisits());
                            int v = input.nextInt();
                            myClients[2].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[2].getPet1());
                            System.out.println(myClients[2].getPet2());
                            System.out.println(myClients[2].getPet3());
                        }
                    }

                    //id for sam jones
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 47196)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[3].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[3].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[3].getnVisits());
                            int v = input.nextInt();
                            myClients[3].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[3].getPet1());

                        }
                    }

                    //id for jack smith
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 67125)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[4].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[4].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[4].getnVisits());
                            int v = input.nextInt();
                            myClients[4].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[4].getPet1());
                            System.out.println(myClients[4].getPet2());
                            System.out.println(myClients[4].getPet3());
                            System.out.println(myClients[4].getPet4());
                        }
                    }

                    //id for casper ward
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 22234)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[5].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[5].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[5].getnVisits());
                            int v = input.nextInt();
                            myClients[5].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[5].getPet1());
                            System.out.println(myClients[5].getPet2());
                        }
                    }

                    //id for phil mercury
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 21312)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[6].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[6].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[6].getnVisits());
                            int v = input.nextInt();
                            myClients[6].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[6].getPet1());

                        }
                    }

                  //here if the user enters yes, then they will have the clients ids
                  //but now they are all sorted
                } else if (choice == 'y' || choice == 'Y') {
                    //the user is prompted with an option to enter an id of a client
                    System.out.println("\nEnter a clients ID to alter: ");
                    System.out.println("\nHere is a selection of our sorted clients' IDs: " +
                        "\nMorely (15396)" +
                        "\nWilder (78214)" +
                        "\nMiller (96258)" +
                        "\nJones (47196)" +
                        "\nSmith (67125)" +
                        "\nWard (22234)" +
                        "\nMercury (21312)");
                    int enterID = input.nextInt();
                    //here are a bunch of if statements for each id
                    //when entering each id, the user is given a menu to choose from
                    //a lets you change the balance of the specific client
                    //b lets you change the client's number of visits
                    //c lets you list out the client's pets
                    
                    //id for robert morely
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 15396)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[3].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[3].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[3].getnVisits());
                            int v = input.nextInt();
                            myClients[3].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[3].getPet1());
                            System.out.println(myClients[3].getPet2());
                        }
                    }

                    //id for john wilder
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 78214)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[6].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[6].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[6].getnVisits());
                            int v = input.nextInt();
                            myClients[6].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[6].getPet1());

                        }
                    }

                    //id for john miller
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 96258)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[2].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[2].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[2].getnVisits());
                            int v = input.nextInt();
                            myClients[2].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[2].getPet1());
                            System.out.println(myClients[2].getPet2());
                            System.out.println(myClients[2].getPet3());
                        }
                    }

                    //id for sam jones
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 47196)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[0].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[0].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("Enter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[0].getnVisits());
                            int v = input.nextInt();
                            myClients[0].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[0].getPet1());

                        }
                    }

                    //id for jack smith
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 67125)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[4].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[4].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("Enter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[4].getnVisits());
                            int v = input.nextInt();
                            myClients[4].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[4].getPet1());
                            System.out.println(myClients[4].getPet2());
                            System.out.println(myClients[4].getPet3());
                            System.out.println(myClients[4].getPet4());
                        }
                    }

                    //id for casper ward
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 22234)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[5].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[5].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[5].getnVisits());
                            int v = input.nextInt();
                            myClients[5].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[5].getPet1());
                            System.out.println(myClients[5].getPet2());
                        }
                    }

                    //id for phil mercury
                    //contains choices to change their due balance, change
                    //their number of visits and to list out their pets
                    if (enterID == 21312)
                    {
                        System.out.println("\nChoose an option of the patient to change." +
                            "\nEnter 'a' or 'A' to change the outstanding balance." +
                            "\nEnter 'b' or 'B' to change the number of visits." +
                            "\nEnter 'c' or 'C' to list the clients' pets.");
                        choice = input.next().charAt(0);

                        if (choice == 'a' || choice == 'A')
                        {
                            System.out.println("\nEnter a new outstanding balance: ");
                            System.out.println("\nHere is the client's existing balance: ");
                            System.out.println(myClients[1].getoBalance() + " $");
                            double o = input.nextDouble();
                            myClients[1].setoBalance(o);
                            System.out.println("\nHere is the client's changed balance: ");
                            System.out.println(o + " $");

                        } else if (choice == 'b' || choice == 'B')
                        {
                            System.out.println("\nEnter a new visit count: ");
                            System.out.println("\nHere is the client's existing number of visits: ");
                            System.out.println(myClients[1].getnVisits());
                            int v = input.nextInt();
                            myClients[1].setnVisits(v);
                            System.out.println("\nHere is the client's changed number of visits: ");
                            System.out.println(v);

                        } else if (choice == 'c' || choice == 'C')
                        {
                            System.out.println(myClients[1].getPet1());

                        }
                    }
                }
            
                //finally if the user chooses option c, it will print their changes
                //they have made onto a textfile called 'clientdataout.txt'
                //via a printwriter and some for loops and if statements
                } else if (choice == 'c' || choice == 'C')
                {
                   PrintWriter fileout = new PrintWriter("ClientDataOut.txt");
                   
                   for (int i = 0; i < numClients; i++)
                   {
                       fileout.println(myClients[i].toFileOut());
                       int x = myClients[i].getNumPets();
                       if (x == 1)
                       {
                           fileout.println(myClients[i].getPet1());
                        } else if (x == 2) {
                           fileout.println(myClients[i].getPet1());
                           fileout.println(myClients[i].getPet2());
                        } else if (x == 3) {
                           fileout.println(myClients[i].getPet1());
                           fileout.println(myClients[i].getPet2());
                           fileout.println(myClients[i].getPet3());
                        } else if (x == 4) {
                           fileout.println(myClients[i].getPet1());
                           fileout.println(myClients[i].getPet2());
                           fileout.println(myClients[i].getPet3());
                           fileout.println(myClients[i].getPet4());
                        }
                    }
                   
                   //ends with the file closing and the user being prompted
                   //with a message saying that their changes were successfully
                   //outported and saved
                   fileout.close();
                   System.out.println("\nYour changed details were finalized and were saved in" +
                                      " a file named 'ClientDataOut.txt'");
                }
             
             //after the user has finished his option, it will prompt him this message
             //to return to the main main if they type o
             //if not, they can type z and quit
             System.out.println("\nWant to return to the main menu?" + "\nType 'o' or 'O' to do so.");
             System.out.println("\nType 'z' or 'Z' if not and you want to quit the program.");
             choice = input.next().charAt(0); 
             
            }while (choice == 'o' || choice == 'O');
        
        //whole main method ends with a goodbye message and the in scanner closing    
        System.out.println("Goodbye.");    
        in.close();
        }//end of main method
    }//end of driver class


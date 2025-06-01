import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable; //this is for save/load
import java.util.LinkedList; //This is for multiple active sheets
public class Main
{
    //TODO: FEATURE LIST
    /*
    1. File IO (maybe this should be done using something like a CSV? That would probably be easy cause I don't want to write my own save/load routines for this kinda nonsense
        Saving and loading
        saving first cause that's easier
        Loading can suck my nards

    2. Multiple active sheets
           this will hinge off of save / load working. but they should be organized into a linked list or a stack
           LL would probably be a bettery solution or an arrayList
           (SOMETHING DYNAMIC)
           Create a node and then write the sheet to the node once the sheet is fully done. Do it outside the main program loop
           so shit doesn't get partially filled in
           RAAAH INPUT SANITIZATION CAN SUCK MY NAAAAARDS

     */


    //global constants for user input functions to validate their input :>
    final int MINIMUM = 0;
    final int MAXIUMUM = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        //##############################################################################################################
        //VARIABLE SETUP
        boolean setupFlag = false;
        Scanner scanner = new Scanner(System.in);
        LinkedList<PlayerSheet>playerSheets = new LinkedList<>();

        //##############################################################################################################

        //call menu function here
        setupFlag = menu();
        while (setupFlag == true)
        {
            PlayerSheet sheet = new PlayerSheet();
            Scanner userInput = new Scanner(System.in);
            System.out.println(" +++SETUP PLAYER SHEET+++ \n" +
                    "###########################");
            System.out.println("Welcome. We'll now go through the process to setup your character.");
            System.out.println("Who are you?\n" +
                    "Please enter your character's name: ");
            sheet.setName(userInput.nextLine());
            System.out.println("Hello, " + sheet.getName());
            System.out.println("What is your race: ");
            sheet.setRace(userInput.nextLine());
            System.out.println("You're a " + sheet.getRace() + "? alright...");
            //call get Globalclass function
            String playerClass = getGlobalClass();
            sheet.setPlayerClass(playerClass);
            System.out.println("A " + sheet.getPlayerClass() + ", great choice.");
            System.out.println("Every class needs a subclass. What is your subclass?");
            sheet.setSubclass(userInput.nextLine());
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("----------------------------------------------------------------------\n" +
                    "##### Player Information ##### \n" +
                    "Player Name: " + sheet.getName() + "\n" +
                    "Player Race: " + sheet.getRace() + "\n" +
                    "Player Class: " + sheet.getPlayerClass() + "\n" +
                    "Player Subclass: " + sheet.getSubClass());
            System.out.println("----------------------------------------------------------------------\n");
            System.out.println("Let's get your ability scores setup.");
            System.out.println("How strong are you? ");

            //sheet.setStrength(userInput.nextInt());
            sheet.setStrengthModifier(sheet.calculateModifier(sheet.getStrength()));

            System.out.println("Your ability score is: " + sheet.getStrength() + " With a modifier of: " + sheet.getStrengthModifier());
            System.out.println("How dexterous are you? ");
            sheet.setDexterity(userInput.nextInt());
            sheet.setDexterityModifier(sheet.calculateModifier(sheet.getDexterity()));
            System.out.println("Your ability score is: " + sheet.getDexterity() + " With a modifier of: " + sheet.getDexterityModifier());
            System.out.println("How hearty are you? (Constitution)");
            sheet.setConstitution(userInput.nextInt());
            sheet.setConstitutionModifier(sheet.calculateModifier(sheet.getConstitution()));
            System.out.println("Your ability modifier is " + sheet.getConstitutionModifier() + " With a modifier of: " + sheet.getConstitutionModifier());
            System.out.println("What is your intelligence?");
            sheet.setIntelligence(userInput.nextInt());
            sheet.setIntelligenceModifier(sheet.calculateModifier(sheet.getIntelligence()));
            System.out.println("Your ability score is: " + sheet.getIntelligence() + " With a modifier of: " + sheet.getIntelligenceModifier());
            System.out.println("What are your street smarts? (Wisdom)");
            sheet.setWisdom(userInput.nextInt());
            sheet.setWisdomModifier(sheet.calculateModifier(sheet.getWisdom()));
            System.out.println("Lastly, what is your Charisma?");
            sheet.setCharisma(userInput.nextInt());
            sheet.setCharismaModifier(sheet.calculateModifier(sheet.getCharisma()));
            System.out.println("----------------------------------------------------------------------\n" +
                    "Strength: " + sheet.getStrength() + " +" + sheet.getStrengthModifier() + "\n" +
                    "Dexterity: " + sheet.getDexterity() + " +" + sheet.getDexterityModifier() + "\n" +
                    "Constitution: " + sheet.getConstitution() + " +" + sheet.getConstitutionModifier() + "\n" +
                    "Intelligence: " + sheet.getIntelligence() + " +" + sheet.getIntelligenceModifier() + "\n" +
                    "Wisdom: " + sheet.getWisdom() + " +" + sheet.getWisdomModifier() + "\n" +
                    "Charisma: " + sheet.getCharisma() + " +" + sheet.getCharismaModifier());
            System.out.println("----------------------------------------------------------------------\n");

            playerSheets.add(sheet);
            System.out.println("Would you like to create another player? (Y/N)");
            boolean yayornay = yayOrNay();
            if(yayornay == true)
            {
                setupFlag = true;
            }
            else {
                setupFlag = false;
            }
        }
        //end if
        //calling menu
        setupFlag = menu();



        System.out.println("If you can see this you fucked up banana head.");
        scanner.nextLine();



    }//end main
    public static void savePlayerSheet(PlayerSheet playerSheet)
    {
        boolean flag = false;
        String saveFileName = "";
        Scanner userInput = new Scanner(System.in);

        System.out.println("What would you like to name your sheet? (recommend character name)");
        saveFileName = userInput.nextLine();
        userInput.close();
        saveFileName = saveFileName + ".txt"; //add file name so OS knows what to do with it


        File saveFile = new File(saveFileName);
        if (!saveFile.exists()) {
            System.out.println("That file already exists. Would you like to overwrite it? (Y/N)");
            System.out.println("THIS OPERATION CANNOT BE UNDONE.");
            flag = yayOrNay();
            if(flag == true)
            {
                saveFile.delete();
                saveFile = new File(saveFileName);
                System.out.println("File has been overwritten.");
            }
            else {
                System.out.println("File will not be overwritten. Please choose a new file name.");
                saveFileName = userInput.nextLine();
                saveFileName = saveFileName + ".txt";
            }//end else
            //TODO: there's probably a big issue with this file creation IO. There's a change that the file could already exist
            //but I don't want to do anything about it soooooooo



        }//end if
    }


    public static boolean yayOrNay()
    {
        System.out.println("(Y/N)? ");
        Scanner userInput = new Scanner(System.in);
        String yayOrNay = userInput.nextLine();
        userInput.close();
        if (yayOrNay.equalsIgnoreCase("y")) {return true;}
        else if (yayOrNay.equalsIgnoreCase("n")) {return false;}
        else {return false;}
    }

    public static String getGlobalClass()//reads from FINAL STRING CLASS ARRAY
    {
        Scanner userInput = new Scanner(System.in);
        //TODO: Make this a dictionary at some point...
        String[] playerClasses = {"[1] Artificer ", "[2] Barbarian ", "[3] Bard ", "[4] Cleric ", "[5] Druid ", "[6] Fighter ", "[7] Monk ", "[8] Paladin ", "[9] Ranger ", "[10] Rogue ", "[11] Sorcerer ", "[12] Warlock ", "[13] Wizard "};

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter your class based on the following options:");
            System.out.println(playerClasses.toString()); //oh em gee why can't there be a simple printout for strings
            for (int i = 0; i < playerClasses.length; i++) {
                System.out.println(playerClasses[i]);
            }
            int input = userInput.nextInt();

            //add validation :p

            switch (input) {
                case 1:
                    return "Artificer";
                case 2:
                    return "Barbarian";
                case 3:
                    return "Bard";
                case 4:
                    return "Cleric";
                case 5:
                    return "Druid";
                case 6:
                    return "Fighter";
                case 7:
                    return "Monk";
                case 8:
                    return "Paladin";
                case 9:
                    return "Ranger";
                case 10:
                    return "Rogue";
                case 11:
                    return "Sorcerer";
                case 12:
                    return "Warlock";
                case 13:
                    return "Wizard";
                default:
                    System.out.println("Selection entered is not a valid class");
            }//end switch
        }
        return null;
    }//

    public static boolean menu()
    {
        Scanner input = new Scanner(System.in);
        int selection = 0;
        boolean menuFlag = false;
        while(menuFlag == false)
        {
            System.out.println("###APPLICATION MENU### \n" +
                    "Please enter a number to select an option. \n" +
                    "1) Setup character \n" +
                    "2) Extended options \n" +
                    "3) Exit \n" +
                    "4) :3 \n" +
                    "5) Save current player sheet \n" +
                    "6) Load an existing player sheet \n");
            System.out.println("$ ");
            selection = input.nextInt();
            if (selection < 1 && selection > 6) {
                System.out.println("The value entered was not correct. Please try again.");
            }
            else{
                menuFlag = true;
            }//end elif block
        }//end while
        switch(selection)
        {
            case 1:
                System.out.println("Starting character setup...");
                return true;
            //break;
            case 2:
                System.out.println("Extended options: Are currently not implemented. Recalling menu function please wait...");
                menu();
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 4:
                System.out.println(":3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3  \n" +
                        ":3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3  \n" +
                        ":3 :3 :3 :3 :3 :3 :3 :3 :3 ");

            case 5:
                System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                menu();
                break;
            case 6:
                System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                menu();
                break;
            default:
                System.out.println("If you can see this you fucked up hard.");
        }

        return false;
    }
    public int getValidInput()
    {
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        int returnValue = 0;
        while (!validInput)
        {
            System.out.println("$: ");
            returnValue = userInput.nextInt();
            if(returnValue > MINIMUM && returnValue < MAXIUMUM)
            {
                validInput = true;
            }
            else
            {
                System.out.println("Value submitted is not within bounds. MINIMUM: " + MINIMUM + " MAXIMUM: " + MAXIUMUM);
            }//end else
        }//end while
        return returnValue;
    }
    public String getValidString()
    {
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        String returnValue = "";


        return returnValue;
    }


}//end main class



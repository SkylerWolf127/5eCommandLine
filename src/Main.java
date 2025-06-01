import java.io.IOException;
import java.util.Scanner;
import java.io.File;
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

    3. Add preset options for race, class, and subclass.

    4. Player gender (Woke update fr)

    5. Create a dedicated function to setup playerSheets (think iter_03 from C class for that dedicated struct setup

     */
    //TODO: BUG "unintentional features" list
    /*
            1. Creating a character adding more than one or saying no to adding more causes program crash
                Something to do with scanner probably

            2. Strength modifier always fails and will default to -20 with a modifier of -5

            3. values inputted for character traits does not get sanitized and properly validated

            4. Subclasses not working properly. Consider consolidating globalPlayerClass and globalPlayerSubClass into one larger method.
            


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
        menu(playerSheets);
        //end if
        //calling menu
        menu(playerSheets);

        System.out.println("If you can see this you fucked up banana head.");
        scanner.nextLine();
        scanner.close();



    }//end main

    public static void setupPlayerSheet(LinkedList<PlayerSheet> playerSheets)
    {
        Scanner userInput = new Scanner(System.in);
        //boolean setupFlag = true;

            PlayerSheet sheet = new PlayerSheet();
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
            String playerSubClass = getGlobalSubClass(playerClass);
            sheet.setSubclass(playerSubClass);
            //sheet.setSubclass(userInput.nextLine());
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

            sheet.setStrength(userInput.nextInt());
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
    }//end setupPlayerSheet

    public static void savePlayerSheet(PlayerSheet playerSheet)//this has not been implemented fully
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
    }//end getGlobalClass

    public static String getGlobalSubClass(String playerClass)
    {
        String[] artificerSubClass = {"[1] Alchemist ", "[2] Armorer ", "[3] Artillerist ", "[4] Battle Smith "};
        String[] barbarianSubClass = {"[1] Ancestral Guardian ", "[2] Battleranger ", "[3] Beast ", "[4] Berserker ", "[5] Giant ", "[6] Storm Herald ", "[7] Totem Warrior ", "[8] Wild Magic ", "[9] Zealot "};
        String[] bardSubClass = {"[1] Creation ", "[2] Eloquence ", "[3] Glamour ", "[4] Lore ", "[5] Spirits ", "[6] Spirits ", "[7] Swords ", "[8] Valor ", "[9] Whispers "};
        String[] clericSubClass = {"[1] Arcana ", "[2] Death ", "[3] Forge ", "[4] Grave ", "[5] Knowledge ", "[6] Life ", "[7] Light ", "[8] Nature ", "[9] Order ", "[10] Peace ", "[11] Tempest ", "[12] Trickery ", "[13] Twilight ", "[14] War "};
        String[] druidSubClass = {"[1] Dreams", "[2] Land ", "[3] Moon ", "[4] Shepard", "[5] Spores ", "[6] Stars ", "[7] Wildfire "};
        String[] fighterSubClass = {"[1] Arcane Archer ", "[2] Banneret ", "[3] Battle Master ", "[4] Cavalier ", "[5] Champion ", "[6] Echo Knight ", "[7] Eldritch Knight ", "[8] Psi Warrior ", "[9] Rune Knight ", "[10] Samurai "};
        String[] monkSubClass = {"[1] Mercy ", "[2] Ascendant Dragon ", "[3] Astral Self ","[4] Drunken Master","[5] Four Elements ","[6] Kensei ","[7] Long Death ","[8] Open Hand ", "[9] Shadow ", "[10] Sun Soul "};
        String[] paladinSubClass = {"[1] Ancients ","[2] Conquest ", "[3] Crown ","[4] Devotion ", "[5] Glory ","[6] Redemption ","[7] Vengeance ","[8] Watchers ","[9] Oathbreaker "};
        String[] rangerSubClass = {"[1] Beast Master Conclave ","[2] Drakewarden ","[3] Fey Wanderer ","[4] Gloom Stalker Conclave ","[5]Horizon Walker Conclave ","[6] Hunter Conclave ","[7] Monster Slayer Conclave ","[8] Swarmkeeper"};
        String[] rogueSubClass = {"[1] Arcane Trickster ","[2] Assassin ","[3] Inquisitive ","[4] Mastermind ","[5] Phantom ","[6] Scout ","[7] Soulknife ","[8] Swashbuckler ","[9] Thief "};
        String[] sorcererSubClass = {"[1] Aberrant Mind ","[2] Clockwork Soul","[3] Draconic Bloodline ","[4] Divine Soul ","[5] Lunar Sorcery ","[6] Shadow Magic ","[7] Storm Sorcery ","[8] Wild Magic" };
        String[] warlockSubClass = {"[1] Archfey ", "[2] Celestial ","[3] Fathomless ","[4] Fiend ","[5] The Genie ","[6] Great Old One ","[7] Hexblade ","[8] Undead ","[9] Undying "};
        String[] wizardSubClass = {"[1] Abjuration ","[2] Bladesinging ","[3] Chrongury ","[4] Conjuration ","[5] Divination ","[6] Enchantment ","[7] Evocation ","[8] Graviturgy ","[9] Illusion ","[10] Necromancy ", "[11] Order of Scribes ", "[12] Transmuation ","[13] War Magic "};

        Scanner userInput = new Scanner(System.in);
        int selection = 0;
        boolean flag = false;
        String returnValue = "";
        System.out.println("Please select a subclass based on the following options: ");

        if(playerClass.toLowerCase() == "artificer")
        {
            System.out.println(artificerSubClass);
            while(flag == false)
            {
                selection = userInput.nextInt();
                switch(selection)
                {
                case 1:
                    returnValue = "Alchemist";
                    flag = true;
                    break;
                case 2:
                    returnValue = "Armorer";
                    flag = true;
                    break;
                case 3:
                    returnValue = "Artillerist";
                    flag = true;
                    break;
                    case 4:
                        returnValue = "Battle Smith";
                        flag = true;
                    default:
                        System.out.println("Value was not vald.");
                }//end switch
            }//end while
        }//end alchemist if
        if(playerClass.toLowerCase() == "barbarian")
        {
            System.out.println(barbarianSubClass);
            while(flag == false)
            {
                selection = userInput.nextInt();
                switch(selection)
                {
                    case 1:
                        returnValue = "Ancestral Guardian";
                        flag = true;
                        break;
                    case 2:
                        returnValue = "Battleranger";
                        flag = true;
                        break;
                    case 3:
                        returnValue = "Beast";
                        flag = true;
                        break;
                    case 4:
                        returnValue = "Berserker";
                        flag = true;
                        break;
                    case 5:
                        returnValue = "Giant";
                        flag = true;
                        break;
                    case 6:
                        returnValue = "Storm Herald";
                        flag = true;
                        break;
                    case 7:
                        returnValue = "Totem Warrior";
                        flag = true;
                        break;
                    case 8:
                        returnValue = "Wild Magic";
                        flag = true;
                        break;
                    case 9:
                        returnValue = "Zealot";
                        flag = true;
                        break;
                    default:
                        System.out.println("Value was not vald.");
                }//end switch
            }//end while

        }//end barbarian if




        return "";
    }

    public static void menu(LinkedList<PlayerSheet> playerSheets) //this method IS recursive. But it won't get into a runaway loop.
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
                    "6) Load an existing player sheet \n" +
                    "7) Display current characters in Linked List");
            System.out.println("$ ");
            selection = input.nextInt();
            if (selection < 1 && selection > 7) {
                System.out.println("The value entered was not correct. Please try again.");
            }
            else{
                menuFlag = true;
            }//end elif block
        }//end while
        switch(selection)
        {
            case 1: //setup character
                System.out.println("Starting character setup...");
                setupPlayerSheet(playerSheets);
                //return true;
                break;
            case 2: //extended options
                System.out.println("Extended options: Are currently not implemented. Recalling menu function please wait...");
                menu(playerSheets);
                break;
            case 3: //Exit
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 4: //:3
                System.out.println(":3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3  \n" +
                        ":3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3 :3  \n" +
                        ":3 :3 :3 :3 :3 :3 :3 :3 :3 ");
                menu(playerSheets);
                break;

            case 5:// Save current player sheet
                System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                menu(playerSheets);
                break;
            case 6: //Load an existing player sheet
                System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                menu(playerSheets);
                break;
            case 7: //Display linked list
                System.out.println("###PLAYER LINKED LIST### \n" +
                        playerSheets.toString());
                menu(playerSheets);
                break;
            default:
                System.out.println("Menu item not valid or implemented.");
                menu(playerSheets);
        }

        //return false;
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



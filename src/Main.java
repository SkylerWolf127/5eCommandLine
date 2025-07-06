import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList; //This is for multiple active sheets
public class Main
{

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
            System.out.println(sheet.getName() + " what a lovely choice.");
            System.out.println("What gender is " + sheet.getName() + "?");
            sheet.setGender(userInput.nextLine());
            System.out.println("What is your race: ");
            sheet.setRace(userInput.nextLine());
            System.out.println("You're a " + sheet.getRace() + "? alright...");
            //call get Globalclass function
            //String playerClass = getGlobalClass();
            //sheet.setPlayerClass(playerClass);
            getGlobalClassSubClass(sheet);
            //String playerSubClass = getGlobalSubClass(playerClass);
            //sheet.setSubclass(playerSubClass);
            //sheet.setSubclass(userInput.nextLine());
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("----------------------------------------------------------------------\n" +
                    "##### Player Information ##### \n" +
                    "Name: " + sheet.getName() + "\n" +
                    "Gender: " + sheet.getGender() + "\n" +
                    "Race: " + sheet.getRace() + "\n" +
                    "Class: " + sheet.getPlayerClass() + "\n" +
                    "Subclass: " + sheet.getSubClass());
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
    public static void printList(String[] list)
    {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
    public static void getGlobalClassSubClass(PlayerSheet playerSheet)
    {
        //this method will combine both getGlobalClass and getGlobalSubclass
        Scanner userInput = new Scanner(System.in);
        //TODO: Make this a dictionary at some point...
        String[] playerClasses = {"[1] Artificer ", "[2] Barbarian ", "[3] Bard ", "[4] Cleric ", "[5] Druid ", "[6] Fighter ", "[7] Monk ", "[8] Paladin ", "[9] Ranger ", "[10] Rogue ", "[11] Sorcerer ", "[12] Warlock ", "[13] Wizard "};
        //SUBCLASSES
        String[] artificerSubClass = {"[1] Alchemist ", "[2] Armorer ", "[3] Artillerist ", "[4] Battle Smith "};
        String[] barbarianSubClass = {"[1] Ancestral Guardian ", "[2] Battleranger ", "[3] Beast ", "[4] Berserker ", "[5] Giant ", "[6] Storm Herald ", "[7] Totem Warrior ", "[8] Wild Magic ", "[9] Zealot "};
        String[] bardSubClass = {"[1] Creation ", "[2] Eloquence ", "[3] Glamour ", "[4] Lore ", "[5] Spirits ", "[6] Swords ", "[7] Valor ", "[8] Whispers "};
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

        boolean validInput = false;
        while(!validInput) {
            System.out.println("Please enter your class based on the following options:\n");
            printList(playerClasses);
            int input = userInput.nextInt();

            {
                switch (input) {
                    case 1:
                        playerSheet.setPlayerClass("Artificer");
                        validInput = true;
                        break;
                    case 2:
                        //return "Barbarian";
                        playerSheet.setPlayerClass("Barbarian");
                        validInput = true;
                        break;
                    case 3:
                        //return "Bard";
                        playerSheet.setPlayerClass("Bard");
                        validInput = true;
                        break;
                    case 4:
                        //return "Cleric";
                        playerSheet.setPlayerClass("Cleric");
                        validInput = true;
                        break;
                    case 5:
                        //return "Druid";
                        playerSheet.setPlayerClass("Druid");
                        validInput = true;
                        break;
                    case 6:
                        //return "Fighter";
                        playerSheet.setPlayerClass("Fighter");
                        validInput = true;
                        break;
                    case 7:
                        //return "Monk";
                        playerSheet.setPlayerClass("Monk");
                        validInput = true;
                        break;
                    case 8:
                        //return "Paladin";
                        playerSheet.setPlayerClass("Paladin");
                        validInput = true;
                        break;
                    case 9:
                        //return "Ranger";
                        playerSheet.setPlayerClass("Ranger");
                        validInput = true;
                        break;

                    case 10:
                        //return "Rogue";
                        playerSheet.setPlayerClass("Rogue");
                        validInput = true;
                        break;
                    case 11:
                        //return "Sorcerer";
                        playerSheet.setPlayerClass("Sorcerer");
                        validInput = true;
                        break;
                    case 12:
                        //return "Warlock";
                        validInput = true;
                        break;
                    case 13:
                        //return "Wizard";
                        playerSheet.setPlayerClass("Wizard");
                        validInput = true;
                        break;
                    default:
                        System.out.println("Selection entered is not a valid class");

                }
            }
            //GET SUBCLASSES
            validInput = false;
            {
                System.out.println("Please enter your subclass based on the following options:\n");
                switch (input) {
                    case 1:
                        printList(artificerSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input) {
                                case 1:
                                    playerSheet.setSubclass("Alchemist");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Armorer");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Artillerist");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Battle Smith");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                            }
                        }
                        break;
                    case 2:
                        //return "Barbarian";
                        //playerSheet.setPlayerClass("Barbarian");
                        printList(barbarianSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Ancestral Guardian");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Battleranger");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Beast");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Berserker");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Giant");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Storm Herald");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Totem Warrior");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Wild Magic");
                                    validInput = true;
                                    break;
                            }
                        }
                        validInput = true;
                        break;
                    case 3:
                        //return "Bard";
                        //playerSheet.setPlayerClass("Bard");

                        printList(bardSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Creation");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Eloquence");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Glamour");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Lore");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Spirits");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Swords");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Valor");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Whispers");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                            }//end switch
                        }//end while
                        validInput = true;
                        break;

                    case 4:
                        //return "Cleric";
                        //playerSheet.setPlayerClass("Cleric");
                        printList(clericSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Arcana Domain");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Death Domain");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Forge Domain");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Grave Domain");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Knowledge Domain");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Life Domain");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Light Domain");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Nature Domain");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Order Domain");
                                    validInput = true;
                                    break;
                                case 10:
                                    playerSheet.setSubclass("Peace Domain");
                                    validInput = true;
                                    break;
                                case 11:
                                    playerSheet.setSubclass("Tempest Domain");
                                    validInput = true;
                                    break;
                                case 12:
                                    playerSheet.setSubclass("Trickery Domain");
                                    validInput = true;
                                    break;
                                case 13:
                                    playerSheet.setSubclass("Twilight Domain");
                                    validInput = true;
                                    break;
                                case 14:
                                    playerSheet.setSubclass("War Domain");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end inner switch


                        }//end while loop
                        validInput = true;
                        break;
                    case 5:
                        //return "Druid";
                        //playerSheet.setPlayerClass("Druid");
                        printList(druidSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Circle of Dreams");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Circle of the Land");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Circle of the Moon");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Circle of the Shepherd");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Circle of Spores");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Circle of Stars");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Circle of Wildfire");
                                    validInput = true;
                                    break;
                                default: System.out.println("Selection entered is not a valid sub class");
                            }//end switch
                        }//end while
                        validInput = true;
                        break;
                    case 6:
                        //return "Fighter";
                        //playerSheet.setPlayerClass("Fighter");
                        printList(fighterSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Arcane Archer");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Banneret");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Battle Master");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Cavalier");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Champion");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Echo Knight");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Eldritch Knight");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Psi Warrior");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Rune Knight");
                                    validInput = true;
                                    break;
                                case 10:
                                    playerSheet.setSubclass("Samurai");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end switch statement
                        }//end while loop
                        validInput = true;
                        break;
                    case 7:
                        //return "Monk";
                        //playerSheet.setPlayerClass("Monk");
                        printList(monkSubClass);
                        while(!validInput)
                        {
                            input = userInput.nextInt();
                            switch (input)
                            {
                                case 1:
                                    playerSheet.setSubclass("Way of Mercy");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Way of the Ascended Dragon");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Way of the Astral Self");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Way of the Drunken Master");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Way of the Four Elements");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Way of the Kensei");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Way of the Long Death");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Way of the Open Hand");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Way of Shadow");
                                    validInput = true;
                                    break;
                                case 10:
                                    playerSheet.setSubclass("Way of the Sun Soul");
                                    validInput = true;
                                    break;
                                    default:
                                        System.out.println("Selection entered is not a valid sub class");
                                        validInput = false;
                            }//end switch
                        }//end while loop
                        validInput = true;
                        break;
                    case 8:
                        //return "Paladin";
                        //playerSheet.setPlayerClass("Paladin");
                        printList(paladinSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("Oath of the Ancients");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Oath of Conquest");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Oath of the Crown");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Oath of Devotion");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Oath of Glory");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Oath of Redemption");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Oath of Vengence");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Oath of the Watchers");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Oathbreaker");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end swtich
                        }//end while
                        validInput = true;
                        break;
                    case 9:
                        //return "Ranger";
                        //playerSheet.setPlayerClass("Ranger");
                        printList(rangerSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("Beast Master Conclave");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Drakewarden");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Fey Wanderer");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Gloom Stalker Conclave");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Horizon Walker Conclave");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Hunter Conclave");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Monster Slayer Conclave");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Swarmkeeper");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end switch
                        }//end while
                        validInput = true;
                        break;

                    case 10:
                        //return "Rogue";
                        //playerSheet.setPlayerClass("Rogue");
                        printList(rogueSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("Arcane Trickster");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Assasin");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Inquisitive");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Mastermine");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Phantom");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Scout");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Soulknife");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Swashbuckler");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Thief");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end switch
                        }//end while
                        validInput = true;
                        break;
                    case 11:
                        //return "Sorcerer";
                        //playerSheet.setPlayerClass("Sorcerer");
                        printList(sorcererSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("Aberrant Mind");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Clockwork Soul");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Draconic Bloodline");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Divine Soul");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("Lunar Sorcery");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Shadow Magic");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Storm Sorcery");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Wild Magic");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;
                            }//end switch
                        }//end while
                        validInput = true;
                        break;
                    case 12:
                        //return "Warlock";
                        printList(warlockSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("Archfey");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("Celestial");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("Fathomless");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("Fiend");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("The Genie");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("Great Old One");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("Hexblade");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("Undead");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("Undying");
                                    validInput = true;
                                    break;
                                    default:
                                        System.out.println("Selection entered is not a valid sub class");
                                        validInput = false;
                            }//end switch
                        }//end while
                        validInput = true;
                        break;
                    case 13:
                        //return "Wizard";
                        //playerSheet.setPlayerClass("Wizard");
                        printList(wizardSubClass);
                        while(!validInput){
                            input = userInput.nextInt();
                            switch (input){
                                case 1:
                                    playerSheet.setSubclass("School of Abjuration");
                                    validInput = true;
                                    break;
                                case 2:
                                    playerSheet.setSubclass("School of Bladesinging");
                                    validInput = true;
                                    break;
                                case 3:
                                    playerSheet.setSubclass("School of Chronurgy");
                                    validInput = true;
                                    break;
                                case 4:
                                    playerSheet.setSubclass("School of Conjuration");
                                    validInput = true;
                                    break;
                                case 5:
                                    playerSheet.setSubclass("School of Divination");
                                    validInput = true;
                                    break;
                                case 6:
                                    playerSheet.setSubclass("School of Enchantment");
                                    validInput = true;
                                    break;
                                case 7:
                                    playerSheet.setSubclass("School of Evocation");
                                    validInput = true;
                                    break;
                                case 8:
                                    playerSheet.setSubclass("School of Graviturgy");
                                    validInput = true;
                                    break;
                                case 9:
                                    playerSheet.setSubclass("School of Illusion");
                                    validInput = true;
                                    break;
                                case 10:
                                    playerSheet.setSubclass("School of Necromancy");
                                    validInput = true;
                                    break;
                                case 11:
                                    playerSheet.setSubclass("Order of Scribes");
                                    validInput = true;
                                    break;
                                case 12:
                                    playerSheet.setSubclass("School of Transmutation");
                                    validInput = true;
                                    break;
                                case 13:
                                    playerSheet.setSubclass("School of War Magic");
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Selection entered is not a valid sub class");
                                    validInput = false;

                            }//end switch
                        }//end while
                        validInput = true;
                        break;
                    default:
                        System.out.println("Selection entered is not a valid class");

                }

            }
        }


    }//end getGlobalClassSubClass

    //PlayerSheetIO.savePlayerSheetToFile(player, "player.dat");
    /*
    PlayerSheet loadedPlayer = PlayerSheetIO.loadPlayerSheetFromFile("player.dat");
        if (loadedPlayer != null) {
            System.out.println("Name: " + loadedPlayer.getName());
     */
    public static void menu(LinkedList<PlayerSheet> playerSheets) //this method IS recursive. But it won't get into a runaway loop.
    {
        Scanner input = new Scanner(System.in);
        int selection = 0;
        boolean menuFlag = false;
        while(menuFlag == false)
        {
            System.out.println("###5eCommandLine MENU###\n" +
                    "Copyright 2025 SkylerWolf\n" +
                    "\nPlease enter a number to select an option. \n" +
                    "1) Setup character \n" +
                    "2) Extended options \n" +
                    "3) Exit \n" +
                    "4) :3 \n" +
                    "5) Save current player sheet \n" +
                    "6) Load an existing player sheet \n" +
                    "### DEBUG LAND ### (Tread with caution brohaus...)\n" +
                    "7) Display current characters in Linked List");

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
                System.out.println("Extended options: This is an unfinished experimental feature");
                extendedMenu(playerSheets);
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
                //System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                if(playerSheets.isEmpty())
                {
                    System.out.println("There is currently not any active sheets in the list.\n" +
                            "Please load a sheet or create a new one.\n" +
                            "Returning to main menu...\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n");
                }
                else {
                    System.out.println("Player sheet will be saved based on the name of the current character sheet.");
                    PlayerSheet saveSheet = playerSheets.get(playerSheets.size() - 1);
                    System.out.println(saveSheet.toString());
                    String saveName = saveSheet.getName();
                    saveName = saveName + ".dat";
                    PlayerSheetIO.savePlayerSheetToFile(saveSheet, saveName);
                }
                menu(playerSheets);
                break;
            case 6: //Load an existing player sheet
                //System.out.println("This functionality has not been implemented yet. Recalling the menu function.");
                System.out.println("Please enter the name of the character you wish to load. The name is CASE SENSITIVE.");
                Scanner userInput = new Scanner(System.in);
                String loadName = userInput.next();
                //append .dat string
                loadName = loadName + ".dat";
                PlayerSheet loadedPlayer = PlayerSheetIO.loadPlayerSheetFromFile(loadName);
                if (loadedPlayer != null) {
                    System.out.println("Name: " + loadedPlayer.getName());
                    playerSheets.add(loadedPlayer);
                }



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
    }//end menu

    public static void extendedMenu(LinkedList<PlayerSheet> playerSheets)
    {
        System.out.println("###Super Secret Extended Menu###\n" +
                "There's nothing here yet. Press any key to go back to the regular menu");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        menu(playerSheets);


    }//end extended menu
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



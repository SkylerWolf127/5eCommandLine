public class PlayerSheet
{
    //instance strings
    private String name;
    private String race;
    private String playerClass;
    private String subClass;
    private String gender;
    //private numbers
    private int healthPoints;
    private int temporaryHealthPoints;
    //PlayerStats
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    //Modifiers
    private int strengthModifier;
    private int dexterityModifier;
    private int constitutionModifier;
    private int intelligenceModifier;
    private int wisdomModifier;
    private int charismaModifier;
    //constructor
    public PlayerSheet()
    {
        this.name = "";
        this.race = "";
        this.playerClass = "";
        this.subClass = "";
        this.healthPoints = 0;
        this.temporaryHealthPoints = 0;
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;
        this.strengthModifier = 0;
        this.dexterityModifier = 0;
        this.constitutionModifier = 0;
        this.intelligenceModifier = 0;
        this.wisdomModifier = 0;
        this.charismaModifier = 0;
    }//end
    public int calculateModifier(int abilityScore)
    {
        int tempScore = abilityScore;
        int modifier = 0;
        switch (tempScore) {
            case 0:
                modifier = -5;
                break;
            case 1:
                modifier = -5;
                break;
            case 2:
                modifier = -4;
                break;
            case 3:
                modifier = -4;
                break;
            case 4:
                modifier = -3;
                break;
            case 5:
                modifier = -3;
                break;
            case 6:
                modifier = -2;
                break;
            case 7:
                modifier = -2;
                break;
            case 8:
                modifier = -1;
                break;
            case 9:
                modifier = -1;
                break;
            case 10:
                modifier = 0;
                break;
            case 11:
                modifier = 0;
                break;
            case 12:
                modifier = 1;
                break;
            case 13:
                modifier = 1;
            case 14:
                modifier = 2;
                break;
            case 15:
                modifier = 2;
                break;
            case 16:
                modifier = 3;
                break;
            case 17:
                modifier =3;
                break;
            case 18:
                modifier = 4;
                break;
            case 19:
                modifier = 4;
                break;
            case 20:
                modifier = 5;
                break;
            default:
                System.out.println("I don't know how you did it buddy, but something went wrong.");
                modifier = -20;
        }

        return modifier;
    }
    public void raceLookUp()
    {
        final String dragonBornArray[];
    }

    //getters and setters
    public String getName()
    {
        return this.name;
    }
    public String getRace()
    {
        return this.race;
    }
    public String getPlayerClass()
    {
        return this.playerClass;
    }
    public String getSubClass()
    {
        return this.subClass;
    }
    public String getGender(){return this.gender;}
    public int getHealthPoints()
    {
        return this.healthPoints;
    }
    public int getTemporaryHealthPoints()
    {
        return this.temporaryHealthPoints;
    }
    public int getStrength()
    {
        return this.strength;
    }
    public int getDexterity()
    {
        return this.dexterity;
    }
    public int getConstitution()
    {
        return this.constitution;
    }
    public int getIntelligence()
    {
        return this.intelligence;
    }
    public int getWisdom()
    {
        return this.wisdom;
    }
    public int getCharisma()
    {
        return this.charisma;
    }
    public int getStrengthModifier()
    {
        return this.strengthModifier;
    }
    public int getDexterityModifier()
    {
        return this.dexterityModifier;
    }
    public int getConstitutionModifier()
    {
        return this.constitutionModifier;
    }
    public int getIntelligenceModifier()
    {
        return this.intelligenceModifier;
    }
    public int getWisdomModifier()
    {
        return this.wisdomModifier;
    }
    public int getCharismaModifier()
    {
        return this.charismaModifier;
    }
    //setter
    public void setName(String newName)
    {
        this.name = newName;
    }
    public void setRace(String newRace)
    {
        this.race = newRace;
    }
    public void setPlayerClass(String newClass)
    {
        this.playerClass = newClass;
    }
    public void setSubclass(String newSubclass)
    {
        this.subClass = newSubclass;
    }
    public void setGender(String newGender){this.gender = newGender;}
    public void setHealthPoints(int newHealthPoints)
    {
        this.healthPoints = newHealthPoints;
    }
    public void setTemporaryHealthPoints(int newTemporaryHealthPoints)
    {
        this.temporaryHealthPoints = newTemporaryHealthPoints;
    }
    public void setStrength(int newStrength)
    {
        this.strength = newStrength;
    }
    public void setDexterity(int newDexterity)
    {
        this.dexterity = newDexterity;
    }
    public void setConstitution(int newConstitution)
    {
        this.constitution = newConstitution;
    }
    public void setIntelligence(int newIntelligence)
    {
        this.intelligence = newIntelligence;
    }
    public void setWisdom(int newWisdom)
    {
        this.wisdom = newWisdom;
    }
    public void setCharisma(int newCharisma)
    {
        this.charisma = newCharisma;
    }
    //set modifiers
    public void setStrengthModifier(int newStrengthModifier)
    {
        this.strengthModifier = newStrengthModifier;
    }
    public void setDexterityModifier(int newDexterityModifier)
    {
        this.dexterityModifier = newDexterityModifier;
    }
    public void setConstitutionModifier(int newConstitutionModifier)
    {
        this.constitutionModifier = newConstitutionModifier;
    }
    public void setIntelligenceModifier(int newIntelligenceModifier)
    {
        this.intelligenceModifier = newIntelligenceModifier;
    }
    public void setWisdomModifier(int newWisdomModifier)
    {
        this.wisdomModifier = newWisdomModifier;
    }
    public void setCharismaModifier(int newCharismaModifier)
    {
        this.charismaModifier = newCharismaModifier;
    }



    //TODO: Implement this eventually

    @Override
    public String toString()
    {

        String returnValue = "";

        return this.name;
    }
}//end PlayerSheet class

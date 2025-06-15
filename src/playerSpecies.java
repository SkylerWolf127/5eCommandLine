public class PlayerSpecies extends PlayerSheet
{

    //TODO: Dictionary for potential player races. Take information from 2024 Player's Handbook.
    private String speciesName;



    public PlayerSpecies()//init vars
    {
        this.speciesName = "";
    }

    @Override
    public String toString()
    {
        return this.speciesName;
    }//end override

}//end PlayerSpeciesClass

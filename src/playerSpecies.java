public class PlayerSpecies extends PlayerSheet
{
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

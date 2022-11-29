public class Player
{
    //Declare variables
    private int health;
    private int armor;
    private int mArmor;

    //Default Constructor
    public Player()
    {
        health = (int)(Math.random()*10+1);
        armor = (int)(Math.random()*10);
        mArmor = (int)(Math.random()*10);
    }
    //Paramaterized Constructor
    public Player(int healthIn, int armorIn, int mArmorIn)
    {
        health = healthIn;
        armor = armorIn;
        mArmor = mArmorIn;
    }
    
    //Getters and Setters
    public int getHealth()
    {
        return health;
    }
    public int getArmor()
    {
        return armor;
    }
    public int getMArmor()
    {
        return mArmor;
    }
    public void setHealth(int in)
    {
        health = in;
    }
    public void setArmor(int in)
    {
        armor = in;
    }
    public void setMArmor(int in)
    {
        mArmor = in;
    }

    //Class Specific Methods
    //Prints out a users stats
    public void stats()
    {
        System.out.printf("%s %d%n%s %d%n%s %d%n%n", "Health:", health, "Armor:", armor, "Magic Armor:", mArmor);
    }
    //Change Health of a player
    public void changeHealth(int in)
    {
        health += in;
    }
    //Decrease armor stat
    public void armorHit()
    {
        armor--;
    }
    //Decrease magic armor stat
    public void mArmorHit()
    {
        mArmor--;
    }
}
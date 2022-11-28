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
        armor = (int)(Math.random()*10+1);
        mArmor = (int)(Math.random()*10+1);
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
    public void stats()
    {
        System.out.printf("%s %d%n%s %d%n%s %d%n", "Health:", health, "Armor:", armor, "Magic Armor:", mArmor);
    }
}
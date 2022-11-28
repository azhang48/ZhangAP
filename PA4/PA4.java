import java.util.Scanner;

public class PA4
{
    public static void main(String[] args)
    {
        //Declare Variables
        Scanner in = new Scanner(System.in);
        Player user = new Player();
        Player AI = new Player();

        //Create the user player, and the AI
        createUser(user);
        createAI(AI);
    }

    //Create user method
    public static void createUser(Player playerIn)
    {
        //Declare variables
        int healthIn, armorIn, mArmorIn, answerChoice;
        boolean answerGood = false;
        Scanner in = new Scanner(System.in);

        //Get user input and create player
        while(!answerGood)
        {
            System.out.println("Enter 1 for random stats, 2 to input your own stats");
            answerChoice = in.nextInt();
            if(answerChoice == 1)
            {
                answerGood = true;
            }
            else if(answerChoice == 2)
            {
                System.out.println("What do you want your health to be?");
                healthIn = in.nextInt();
                System.out.println("What do you want your armor to be?");
                armorIn = in.nextInt();
                System.out.println("What do you want your magic armor to be?");
                mArmorIn = in.nextInt();
                playerIn.setHealth(healthIn);
                playerIn.setArmor(armorIn);
                playerIn.setMArmor(mArmorIn);
                answerGood = true;
            }
            else
            {
                System.out.println("Sorry, that is not a valid option");
            }
        }
    }
    //Create AI Method
    public static void createAI(Player playerIn)
    {
        //Declare variables
        int difficultyLevel, answerChoice;
        boolean answerGood = false;
        Scanner in = new Scanner(System.in);

        //Get user input and create player
        while(!answerGood)
        {
            System.out.println("Enter 1 for random stats, 2 to select difficulty level");
            answerChoice = in.nextInt();
            if(answerChoice == 1)
            {
                answerGood = true;
            }
            else if(answerChoice == 2)
            {
                System.out.println("Pick a difficulty level 1-10 (difficulty level will become every stat for the computer)");
                difficultyLevel = in.nextInt();
                if(difficultyLevel<1||difficultyLevel>10)
                {
                    System.out.println("The number inputted is not between one and ten, difficulty will be set to 5");
                    difficultyLevel = 5;
                    playerIn.setHealth(difficultyLevel);
                    playerIn.setArmor(difficultyLevel);
                    playerIn.setMArmor(difficultyLevel);
                }
                else 
                {
                    playerIn.setHealth(difficultyLevel);
                    playerIn.setArmor(difficultyLevel);
                    playerIn.setMArmor(difficultyLevel);
                }
                answerGood = true;
            }
            else
            {
                System.out.println("Sorry, that is not a valid option");
            }
        }
    }
}
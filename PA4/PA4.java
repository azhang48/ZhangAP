import java.util.Scanner;

public class PA4
{
    public static void main(String[] args)
    {
        //Declare Variables
        Player user = new Player();
        Player AI = new Player();

        //Create the user player, and the AI
        createUser(user);
        createAI(AI);

        //Print out stats
        printStats(user, AI);

        //Start game
        PlayGame(user, AI);
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
            System.out.print("FOR PLAYER - Enter 1 for random stats, 2 to input your own stats: ");
            answerChoice = in.nextInt();
            if(answerChoice == 1)
            {
                answerGood = true;
            }
            else if(answerChoice == 2)
            {
                //Get User Input, make sure its an accpeted value
                System.out.print("What do you want your health to be (Cannot be zero or negative)? " );
                healthIn = in.nextInt();
                if(healthIn < 1)
                {
                    System.out.println("Invalid input, randomizing health");
                    healthIn = (int)(Math.random()*10+1);
                }
                System.out.print("What do you want your armor to be (0-9)? " );
                armorIn = in.nextInt();
                if(armorIn > 9||armorIn < 0)
                {
                    System.out.println("Invalid input, randomizing armor");
                    armorIn = (int)(Math.random()*10);
                }
                System.out.print("What do you want your magic armor to be (0-9)? " );
                mArmorIn = in.nextInt();
                if(mArmorIn > 9||mArmorIn < 0)
                {
                    System.out.println("Invalid input, randomizing magic armor");
                    mArmorIn = (int)(Math.random()*10);
                }
                //Set user input to the values
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
            System.out.print("FOR COMPUTER - Enter 1 for random stats, 2 to select difficulty level: ");
            answerChoice = in.nextInt();
            if(answerChoice == 1)
            {
                answerGood = true;
            }
            else if(answerChoice == 2)
            {
                System.out.print("Pick a difficulty level 1-10: ");
                difficultyLevel = in.nextInt();
                if(difficultyLevel<1||difficultyLevel>10)
                {
                    System.out.println("The number inputted is not between one and ten, difficulty will be set to 5");
                    difficultyLevel = 5;
                    playerIn.setHealth(difficultyLevel);
                    playerIn.setArmor(difficultyLevel-1);
                    playerIn.setMArmor(difficultyLevel-1);
                }
                else 
                {
                    playerIn.setHealth(difficultyLevel);
                    playerIn.setArmor(difficultyLevel-1);
                    playerIn.setMArmor(difficultyLevel-1);
                }
                answerGood = true;
            }
            else
            {
                System.out.println("Sorry, that is not a valid option");
            }
        }
    }
    //Play Game
    public static void PlayGame(Player user, Player AI)
    {
        //Declare variables
        boolean gameRunning = true;
        int winner = 0; //1 for user, 2 for AI, 3 for tie
        Scanner in = new Scanner(System.in);
        int userInput, roundNumber = 1;

        //Introduction, offer instructions
        System.out.print("Welcome to Programming Assignment 4, a Rock, Paper, Scissors Game!");
        System.out.print("Would you like to view the instructions? 1)Yes 2)No\nYour Choice: ");
        userInput = in.nextInt();
        if(userInput == 1)
        {
            PrintInstructions();
        }
        System.out.println();
        //Start gameplay loop
        while(gameRunning)
        {
            System.out.printf("%s %d%n", "Round Number: ", roundNumber);
            System.out.printf("%s %d    %s %d%n", "Your HP:",user.getHealth(),"Computer HP:",AI.getHealth());
            System.out.println("Do you want to:\n1)Play Round\n2)View Instructions\n3)Check Stats\n4)Quit\n");
            userInput = in.nextInt();
            switch(userInput)
            {
                case 1:
                {
                    playRound(user, AI);
                    break;
                }
                case 2:
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~INSTRUCTIONS~~~~~~~~~~~~~~~~~~~~~~~");
                    PrintInstructions();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                }
                case 3:
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~STATS~~~~~~~~~~~~~~~~~~~~~~~");
                    printStats(user, AI);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                }
                case 4:
                {
                    gameRunning = false;
                    break;
                }
                default:
                {
                    System.out.println("Invalid Input");
                }
            }
            //Check if there is winner
            if(user.getHealth()<1)
            {
                if(AI.getHealth()<1)
                {
                    winner = 3;
                }
                else
                {
                    winner = 2;
                }
                gameRunning = false;
            }
            else if(AI.getHealth()<1)
            {
                winner = 1;
                gameRunning = false;
            }
            else
            {
                roundNumber++;
            }
        }
        //Declare Winner
        if(winner == 1)
        {
            System.out.println("YOU WIN!!!! CONGRATS!!!!\nHere are your stats:");
            printStats(user, AI);
        }
        else if(winner == 2)
        {
            System.out.println("Aww, you lost :( You'll get it next time!\nHere are your stats:");
            printStats(user, AI);
        }
        else if(winner == 3)
        {
            System.out.println("Double knockout! Its a tie!\nHere are your stats");
            printStats(user, AI);
        }
    }
    //Print Stats
    public static void printStats(Player p1, Player p2)
    {
        System.out.println("\nPLAYER STATS:");
        p1.stats();
        System.out.println("COMPUTER STATS:");
        p2.stats();
    }
    //Play Round
    public static void playRound(Player user, Player AI)
    {
        //Declare Variables
        Scanner in = new Scanner(System.in);
        int userInput;

        //Run Round
        System.out.print("What do you want to do?\n1)Attack\n2)Cast A Spell\n3)Defend\n4)Heal\n");
        userInput = in.nextInt();
        combatCheck(userInput, getAIMove(AI), user, AI);
    }
    //Combat Check
    public static void combatCheck(int p1Move, int p2Move, Player p1, Player p2)
    {
        System.out.println();
        //Declare variable
        int randomizer = (int)(Math.random()*10);

        //Same move result
        if(p1Move == p2Move)
        {
            if(p1Move == 1)
            {
                System.out.println("You and your opponent both attack, exchanging blows. In the end, neither of you took damage.\n");
            }
            else if(p1Move == 2)
            {
                System.out.println("You and your opponent both launch a spell, resulting in a fantastic fireworks show.\nNeither of you take damage\n");
            }
            else if(p1Move == 3)
            {
                System.out.println("*silence* ... well ... this is awkward. Both of you and your opponent take a defensive stance.\n");
            }
            else if(p1Move == 4)
            {
                System.out.println("Nice, your rest was undisturbed, and you got some healing in!\nToo bad your opponent had the same plan. Both you and your opponent heal 1 health.\n");
                p1.changeHealth(1);
                p2.changeHealth(1);
            }
        }
        //player1 Attacks
        else if(p1Move == 1)
        {
            if(p2Move == 2)
            {
                if(randomizer < p2.getArmor())
                {
                    System.out.println("While your opponent prepares to cast his spell, you dash at him. Your attack connects!\nHowever, your opponents armor is too strong. They take no damage. Their armor weakens.\n");
                    p2.armorHit();
                }
                else
                {
                    System.out.println("While your opponent prepares to cast his spell, you dash at him. Your attack connects!\n*CRACK* Your opponent takes a point of damage.\n");
                }
            }
            else if(p2Move == 3)
            {
                System.out.println("You charge in fearlessly to attack, *BAM*. Your opponent's defensive stance broke through your attack!\nYou take a point of damage.\n");
                p1.changeHealth(-1);
            }
            else if(p2Move == 4)
            {
                System.out.println("Nice, while your opponent takes a break, you rush in with you attack. *WHACK*.\nYour defenseless opponent takes two damage.\n");
                p2.changeHealth(-2);
            }
        }
        //player1 Spellcasts
        else if(p1Move == 2)
        {
            if(p2Move == 1)
            {
                if(randomizer < p1.getArmor())
                {
                    System.out.println("Still casting your spell, your opponent attacks. Rude!\nLuckily, your armor absorbs the impact. You take no damage. Your armor weakens.\n");
                    p1.armorHit();
                }
                else
                {
                    System.out.println("Uhhh... how did that spell go again? While fumbling through your spellbook, your opponent strikes!\n*WHACK* That'll hurt! You take a point of damage.\n");
                    p1.changeHealth(-1);
                }
            }
            else if(p2Move == 3)
            {
                if(randomizer < p2.getMArmor())
                {
                    System.out.println("You cast a spell, blasting your opponent who has taken a defensive stance\nUnfortunately, their magic armor was able to absorb the impact. They take no damage. Their magic armor weakens.\n");
                    p2.mArmorHit();
                }
                else
                {
                    System.out.println("Your opponent takes a defensive stance, giving you all the time in the world to cast your spell\n*WHOOOOM* Your spell lands. Your opponent takes a point of damage\n");
                    p2.changeHealth(-1);
                }
            }
            else if(p2Move == 4)
            {
                System.out.println("While your opponent takes a quick rest, your spell blasts him! *FWOOOOM*.\nYour defenseless opponent takes two damage.\n");
                p2.changeHealth(-2);
            }
        }
        //player1 defends
        else if(p1Move == 3)
        {
            if(p2Move == 1)
            {
                System.out.println("Your opponent charges in, but you're ready. With your defensive stance, your opponent is no match.\nYour opponent takes a point of damage\n");
                p2.changeHealth(-1);
            }
            else if(p2Move == 2)
            {
                if(randomizer < p1.getMArmor())
                {
                    System.out.println("*SHOOOM* Your opponents spell rockets into your defensive stance!\nNice, your magic armor aborbs the impact. You take no damage. Your magic armor weakens.\n");
                    p1.mArmorHit();
                }
                else
                {
                    System.out.println("'Huh, its awfully quiet' you think. *BLAM* Your opponents spell slams into you.\nOuch! You take a point of damage\n");
                    p1.changeHealth(-1);
                }
            }
            else if(p2Move == 4)
            {
                System.out.println("From behind your defensive stance, you see your opponent take a quick break.\nDarn! Your opponent heals a point of health\n");
                p2.changeHealth(1);
            }
        }
        //player1 heals
        else if(p1Move == 4)
        {
            if(p2Move == 1)
            {
                System.out.println("Uh oh, just as you take your armor off, your opponent charges in.\n*CRUNCH* You take two points of damage.\n");
                p1.changeHealth(-2);
            }
            else if(p2Move == 2)
            {
                System.out.println("Ah shoot, armor halfway off, you feel your opponents spell land.\n*FWOOOOOSH* You take two points of damage.\n");
                p1.changeHealth(-2);
            }
            else if(p2Move == 3)
            {
                System.out.println("While your opponent takes a defensive stance, you take a break!\nYou heal one point of health\n");
                p1.changeHealth(1);
            }
        }
    }
    //Get AI Decision
    public static int getAIMove(Player AI)
    {
        //declare variable
        int randomizer;

        //If health is below 3 40% chance for AI to go for a heal move
        if(AI.getHealth() < 3)
        {
            randomizer = (int)(Math.random()*100 + 1);
            if(randomizer < 41)
            {
                return 4;
            }
            else
            {
                randomizer = (int)(Math.random()*100 + 1);
                if(randomizer < 34)
                {
                    return 1;
                }
                else if(randomizer < 67 && randomizer > 34)
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
        }
        //If health is below 6 15% chance for AI to go for a heal
        else if(AI.getHealth() < 6)
        {
            randomizer = (int)(Math.random()*100 + 1);
            if(randomizer < 16)
            {
                return 4;
            }
            else
            {
                randomizer = (int)(Math.random()*100 + 1);
                if(randomizer < 34)
                {
                    return 1;
                }
                else if(randomizer < 67 && randomizer > 34)
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
        }
        //If health is greater than 6 AI will have a 5% chance to attempt a heal
        else
        {
            randomizer = (int)(Math.random()*100 + 1);
            if(randomizer < 6)
            {
                return 4;
            }
            else
            {
                randomizer = (int)(Math.random()*100 + 1);
                if(randomizer < 34)
                {
                    return 1;
                }
                else if(randomizer < 67 && randomizer > 34)
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
        }
    }
    //Print Instructions
    public static void PrintInstructions()
    {
        System.out.println("\nINSTRUCTIONS:\nEach turn you will have the option to either Attack, Defend, Cast a Spell, or Heal");
        System.out.println("\nAttacking - Attack quickly and strike any opponent casting a spell!\n\tCareful though, if they have taken a defensive stance you'll be the one getting struck!");
        System.out.println("\nSpellcasting - Cast a spell and break through your opponents defensive stance!\n\tWatch out for attackers though, since they'll get you before your spell even casts!");
        System.out.println("\nDefending - Assume a strong, defensive stance, and strike down any opponent foolish enough to attack you!\n\tHowever, be warned... you'll be a sitting duck to anyone casting a spell!");
        System.out.println("\nHealing - Shed that armor, take a breather, and recover some health! :D\n\tUse with caution, anyone on the offense will deal twice the damage, and your armor will be of no use! D:");
        System.out.println("\nArmor explained - Magic Armor reduces your chance of taking spell damage, while Armor reduces your chances of taking regular damage\nEverytime the stat successfully blocks an attack, it decreases by 1\n");
    }  
}
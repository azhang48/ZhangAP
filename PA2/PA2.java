import java.util.Scanner;

public class PA2
{
    public static void main(String[] args)
    {
        //Declare Variables and Scanner
        int guess, number, tries;
        boolean numberNotGuessed = true;
        Scanner guessIn = new Scanner(System.in);

        //Create number to guess, 0 - 20;
        number = (int)(Math.random()*101);
        
        //Start playing!
        tries = 1;
        while(numberNotGuessed)
        {
            //Get Guess
            System.out.print("What is your guess [0-100]? ");
            guess = guessIn.nextInt();
            
            //Check if guess is right
            if(guess == number)
            {
                numberNotGuessed = false;
                guessIn.close();
            }
            else
            {
                //Increase number of tries
                tries++;

                //Check if higher or lower
                if(guess > number)
                {
                    System.out.println("Too high! Try again!");
                }
                else
                {
                    System.out.println("Too low! Try again!");
                }
            }
        }

        //Print number of tries
        if(tries == 1)
        {
            System.out.println("You got it! That took you 1 try!");
        }
        else
        {
            System.out.println("You got it! That took you " + tries +" tries!");
        } 
    }
}
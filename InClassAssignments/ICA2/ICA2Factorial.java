import java.util.Scanner;

public class ICA2Factorial
{
    public static void main(String[] args)
    {
        //Declare variables and scanner
        int product, input;
        Scanner in = new Scanner(System.in);

        //Get user input
        System.out.print("What is your number? ");
        input = in.nextInt();

        //Return answer
        product = 1;
        for(int i = input; i>1; i--)
        {
            product *= i;
        }
        System.out.print(input + "! is " + product);
    }
}
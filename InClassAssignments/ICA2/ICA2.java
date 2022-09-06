import java.util.Scanner;

public class ICA2
{
    public static void main(String[] args)
    {
        //Declare variables and scanner
        int Num1, Num2;
        char symbol;
        Scanner symbolIn = new Scanner(System.in);

        //Get user input
        System.out.print("What is your equation? ");
        Num1 = symbolIn.nextInt();
        symbol = symbolIn.next().charAt(0);
        Num2 = symbolIn.nextInt();

        //Check if theres an error
        if(Num1<-999||Num1>999||Num2<-999||Num2>999)
        {
            System.out.println("ERROR: One of the numbers has more than 3 digits");
            System.exit(0);
        }
        if(symbol != '+' && symbol != '-' && symbol != 'x' && symbol != 'X' && symbol != '*' && symbol != '/' && symbol != '%')
        {
            System.out.println("ERROR: Invalid Symbol");
            System.exit(0);
        }

        //Perform Calculations
        if(symbol == '+')
        {
            System.out.print(Num1 + Num2);
        }
        if(symbol == '-')
        {
            System.out.print(Num1 - Num2);
        }
        if(symbol == 'x' || symbol == 'X' || symbol == '*')
        {
            System.out.print(Num1 * Num2);
        }
        if(symbol == '/')
        {
            System.out.print(Num1 / Num2);
        }
        if(symbol == '%')
        {
            System.out.print(Num1 % Num2);
        }
    }
}
import java.util.Scanner;

public class ICA1
{
    public static void main(String[] args)
    {
        //Declare variables
        double teaspoonsIn;
        Scanner askForTeaspoons = new Scanner(System.in);

        //Get User Input
        System.out.print("Enter the amount in teaspoons: ");
        teaspoonsIn = askForTeaspoons.nextDouble();

        //Print Results
        System.out.println('\n' + teaspoonsIn + " teaspoons is:");
        System.out.println(teaspoonsIn/3 + " Tablespoons");
        System.out.println(teaspoonsIn/48 + " Cups");
        System.out.println(teaspoonsIn/96 + " Pints");
        System.out.println(teaspoonsIn/192 + " Quarts");
        System.out.println(teaspoonsIn/768 + " Gallons");
        System.out.println(teaspoonsIn/6 + " Fluid Ounces");
    }
}
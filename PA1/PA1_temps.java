import java.util.Scanner;

public class PA1_temps
{
    public static void main(String[] args)
    {
        //Declarations
        Scanner in = new Scanner(System.in);
        float f, c, k;

        //Input
        System.out.print("How much farenheit? ");
        f = in.nextFloat();

        //Conversion
        c = ((f-32)*5)/9;
        k = c + (float)273.15;

        //Output
        System.out.print("Celsius: " + c + " Kelvin: " + k);
    }
}
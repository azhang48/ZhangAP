import java.util.Scanner;

public class PA1_time
{
    public static void main(String[] args)
    {
        //declarations
        Scanner in = new Scanner(System.in);
        int h , m ,s;

        //input
        System.out.print("How many seconds? ");
        h = in.nextInt();
        
        //calculations
        m = h%3600;
        s = m%60;

        h /= 3600;
        m /= 60;

        //Output
        System.out.print(h + " hours, " + m + " minutes, " + s + " seconds");
    }
}
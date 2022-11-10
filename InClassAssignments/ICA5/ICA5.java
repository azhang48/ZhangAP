import java.util.Scanner;

public class ICA5
{
    public static void main(String[] args)
    {
        //Declare scanner and variables
        String str1, str2;
        Scanner in = new Scanner(System.in);

        //Get User Input
        System.out.printf("%s%n", "What is the first string?");
        str1 = in.next();
        System.out.printf("%s%n", "What is the second string?");
        str2 = in.next();

        //Check if strings are same length
        if(str1.length()!=str2.length())
        {
            System.out.printf("%s", "The two strings are not anagrams");
        }
        else
        {
            //Put the strings into arrays
            //declare char arrays the length of the string
            char[] strArr1 = new char[str1.length()];
            char[] strArr2 = new char[str2.length()];

            for(int i=0;i<str1.length();i++)
            {
                strArr1[i] = str1.charAt(i);
                strArr2[i] = str2.charAt(i);
            }
        }
    }
}
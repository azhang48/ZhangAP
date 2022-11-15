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
            
            //Make strings all lowercase
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            //Iterates through each index of string and puts it into array
            for(int i=0;i<str1.length();i++)
            {
                strArr1[i] = str1.charAt(i);
                strArr2[i] = str2.charAt(i);
            }

            //Sort each array
            int min, savedOffset = 0;

            for(int i=0; i<strArr1.length; i++)
            {
                min = strArr1[i];
                for(int j=i; j<strArr1.length; j++)
                {
                    if(strArr1[j] <= min)
                    {
                        savedOffset = j;
                        min = strArr1[j];
                    }
                }
                strArr1[savedOffset] = strArr1[i];
                strArr1[i] = (char)min;
            }
            for(int i=0; i<strArr2.length; i++)
            {
                min = strArr2[i];
                for(int j=i; j<strArr2.length; j++)
                {
                    if(strArr2[j] <= min)
                    {
                        savedOffset = j;
                        min = strArr2[j];
                    }
                }
                strArr2[savedOffset] = strArr2[i];
                strArr2[i] = (char)min;
            }

            //Compare each index to see if they are anagrams
            for(int i=0;i<strArr1.length;i++)
            {
                if(strArr1[i] != strArr2[i])
                {
                    i = strArr1.length + 10;
                    System.out.printf("%n%s", "The two are not anagrams");
                }
                if(i == strArr1.length-1 && strArr1[i] == strArr2[i])
                {
                    System.out.printf("%n%s", "The two are anagrams");
                }
            }
        }     
    }
}
import java.util.Scanner;

public class ICA31
{
    public static void main(String[] args)
    {
        //Declare Stuff, Create Array, Sort Array, Print Array
        Scanner in = new Scanner(System.in);
        int[] vals = new int[10000];
        int target = 0;
        int valueHolder = 0;
        int sSearchIterations = 0;
        int bSearchIterations = 0;
        boolean valueFound = false;

        for(int i=0;i<vals.length;i++)
        {
            vals[i] = ((int)(Math.random()*20000)+1);
        }

        System.out.printf("%s %d%n%s %d%n%s %d%n","Min:",findMin(vals),"Max:",findMax(vals),"Average:",findAvg(vals));
        //Insertion Sort
        for(int i=0; i<vals.length; i++)
        {
            valueHolder = vals[i];
            for(int j=(i-1); j>=0; j--)
            {
                if(valueHolder < vals[j])
                {
                    vals[j + 1] = vals[j];
                    vals[j] = valueHolder;
                }
            }
        }

        //Get User Input
        System.out.printf("%s ", "What value (1-20000) do you want to search for?");
        target = in.nextInt();
        System.out.printf("%s %d%n", "Searching for", target);
        in.close();

        //Sequential Search
        for(int i=0;i<vals.length&&!valueFound;i++)
        {
            if(vals[i] == target)
            {
                sSearchIterations = i;
                valueFound = true;
            }
        }
        
        //Print results for sequential search if value found
        if(valueFound)
        {
            System.out.printf("%s %d %s %d %s%n","Sequential Search: ", target, "found in", sSearchIterations, "iterations ");
        }
        valueFound = false;

        //Binary Search
        int last = vals.length - 1;
        int first = 0;
        int mid;

        while(!valueFound&&first != last)
        {
            mid = (last + first)/2; 
            if(vals[mid] == target)
            {
                valueFound = true;
            }
            else
            {
                if(vals[mid] > target) //If x is less than mid
                {
                    last = mid - 1;
                }
                if(vals[mid] < target) //If x is greater than mid
                {
                    first = mid + 1;
                }
            }
            bSearchIterations++;
        }
        //Print results of binary search if found
        if(valueFound)
        {
            System.out.printf("%s %d %s %d %s%n","Binary Search: ", target, "found in", bSearchIterations, "iterations ");
        }
        
        //Print result if value wasn't found
        else
        {
            System.out.printf("%d %s %n", target, "was not found");
        }
    }

public static int findMax(int[] arrIn)
{
    int max = arrIn[0];
    for(int i:arrIn)
    {
        if(i>max)
        {
            max = i;
        }
    }
    return max;
}

public static int findMin(int[] arrIn)
{
    int min = arrIn[0];
    for(int i:arrIn)
    {
        if(i<min)
        {
            min = i;
        }
    }
    return min;
}

public static int findAvg(int[] arrIn)
{
    int avg = 0;
    for(int i:arrIn)
    {
        avg += i;
    }
    avg /= arrIn.length;
    return avg;
}

}

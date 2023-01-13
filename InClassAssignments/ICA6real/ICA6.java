public class ICA6
{
    public static void main(String[] args)
    {
        //Declare array
        int[][] arr = new int[10][10];

        //Run for loop
        for(int i=0; i< arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                //Checks if our index is on a diagonal
                {
                    if(i==j)
                    {
                        System.out.printf("%-4d", i*j);
                    }
                    else if(i+j == 11)
                    {
                        System.out.printf("%-4d", i*j);
                    }
                    else
                    {
                        System.out.printf("%-4d", i+j);
                    }
                }
            }
        }
    }
}
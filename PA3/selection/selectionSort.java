public class selectionSort
{
    public static void main(String[] args)
    {
        //declare variables
        int[] testArr = new int[] {5, 30, 23, 4, 6, 88, 27, 32, 17, 13};
        int min, savedOffset;
        savedOffset = 0;
        
        //selection sort
        for(int i=0; i<testArr.length; i++) //Outer loop, i is the first index of the unsorted portion of the array
        {
            min = 999;                      //Reset min each interation
            for(int j=i; j<testArr.length; j++) //Inner loop runs from the first index of unsorted portion to end of array
            {
                if(testArr[j] < min)        //Finds the smallest number of the unsorted portion
                {
                    savedOffset = j;
                    min = testArr[j];
                }
            }

            //swaps the smallest value of the unsorted portion with the first index, i, of the unsorted portion
            testArr[savedOffset] = testArr[i];
            testArr[i] = min;

            //Printing
            for(int k=0; k<i; k++)                              //For loop that runs to one before the end of our sorted loop
            {
                System.out.printf("%-2d ", testArr[k]);
            }
            System.out.printf("%-2d%c", testArr[i], '|');       //Prints out the value we just sorted to, with a bar to contrast what we haven't sorted
            for(int k=(i+1); k<testArr.length; k++)             //For loop that runs from our first unsorted value to the end of array
            {
                System.out.printf("%-2d ", testArr[k]);
            }
            System.out.printf("%n");
        }

    }
}

//Less checks since I copied code I'd already tested from insertion sort
public class insertionSort
{
    public static void main(String[] args)
    {
        //Declare variable
        int valueHolder = 0;            //Holds the value of the number we are comparing(inserting)
        int[] testArr = new int[] {5, 30, 23, 4, 6, 88, 27, 32, 17, 13};
        
        //Insertion Sort
        for(int i=0; i<testArr.length; i++) //Outer Loop, grabs the next unsorted value each iteration starting from offset 0
        {
            valueHolder = testArr[i];      //Holds the value we are comparing in an int, so we don't have to worry about the offset of the value we are checking changing
 
            for(int j=(i-1); j>=0; j--) //Inner Loop, starts at the offset right before the value we are currently sorting, decrements until we reach offset 0
            {
                if(valueHolder < testArr[j]) //If the value of the number we are comparing is less than the number before it, we will swap the two
                {
                    testArr[j + 1] = testArr[j]; //Moves the higher value into our value's spot
                    testArr[j] = valueHolder;    //Puts our value into the higher value's old spot
                }
            }

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
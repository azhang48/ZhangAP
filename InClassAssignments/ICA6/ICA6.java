public class ICA6
{
    public static void main(String[] args)
    {
        //Initialize array
        int [][] my2D = new int[10][10];
        
        //Run loops
        for(int row = 0; row<my2D.length; row++)
        {
            for(int col = 0; col<my2D[row].length;col++)
            {
                if(row == 0 && col == 0)
                {
                    my2D[row][col] = 1;
                }
                else
                {
                    if(row == 0)
                    {
                        my2D[row][col] = 1;
                    }
                    else if(col == 0)
                    {
                        my2D[row][col] = 1;
                    }
                    else
                    {
                        my2D[row][col] = my2D[row-1][col] + my2D[row][col-1];
                    }
                }
            }
        }
        //Print
        for(int row=0;row<my2D.length;row++)
        {
            for(int col=0;col<my2D[row].length;col++)
            {
                System.out.printf("%-6d ",my2D[row][col]);
            }
            System.out.println();
        }
    }
}
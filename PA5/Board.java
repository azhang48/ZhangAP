public class Board
{
    //Declare variables
    private int[][] board;

    //Constructors
    public Board()
    {
        board = new int[7][7];
    }

    //Setters
    public int getTile(int x, int y)
    {
        return board[y][x];
    }
    public void setTile(int x, int y, int numIn)
    {
        board[y][x] = numIn;
    }

    //Print Board Function
    public void printBoard()
    {
        for(int row=board.length-1;row>-1;row--)
        {
            System.out.printf("%n%s%n%s"," __ __ __ __ __ __ __ ","|");
            for(int col=0;col<board[row].length;col++)
            {
                if(board[row][col]==0)
                {
                    System.out.print("  |");
                }
                else if(board[row][col]==1)
                {
                    System.out.print("x |");
                }
                else if(board[row][col]==2)
                {
                    System.out.print("o |");
                }
                else
                {
                    System.out.print("~~|");
                }
            }
        }
        System.out.printf("%n%s%n"," 1  2  3  4  5  6  7");
    }
}
import java.util.Scanner;

public class PA5
{
    public static void main(String[] args)
    {
        //Declare and initialize variables
        Board board = new Board();
        boolean validMove = false;
        boolean gameRunning = true;
        int playerMove = 0;
        Scanner in = new Scanner(System.in);

        //Start Game
        while(gameRunning)
        {
            board.printBoard();

            //Player 1 Move
            while(validMove == false)
            {
                //Get user input
                System.out.print("Player 1, select a column to move in: ");
                playerMove = in.nextInt();

                //Check if move is ok
                if(moveOK(playerMove, board))
                {
                    validMove = true;
                    makeMove(playerMove-1, 1, board);
                }
            }
            validMove = false;
        }
    }
    //Checks if a piece is movable
    public static boolean moveOK(int move, Board boardIn)
    {
        if(move < 1||move > 7)
        {
            System.out.println("ERROR: Column does not exist");
            return false;
        }
        else if(boardIn.getTile(move-1, 6)!=0)
        {
            System.out.println("ERROR: Column is full");
            return false;
        }
        else
        {
            return true;
        }
    }
    //Make Move
    public static void makeMove(int move, int playerNum, Board boardIn)
    {
        int row = 7;
        boolean moveOk = true;
        while(moveOk)
        {
            //Makes sure array stays inbounds
            if(row > 0)
            {
                //Checks if the row under is empty, and moves it down if it is
                if(boardIn.getTile(move, row-1) == 0)
                {
                    row--;
                }
                else
                {
                    moveOk = false;
                }
            }
            else
            {
                moveOk = false;
            }
        }
        boardIn.setTile(move, row, playerNum);
    }
}
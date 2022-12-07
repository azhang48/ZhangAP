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

        board.setTile(0, 6, 2);
        board.setTile(6, 5, 1);

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
}
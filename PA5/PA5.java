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
            board.printBoard();

            //Check if game is over
            if(checkGameOver(board))
            {
                gameRunning = false;
            }
            else
            {
                validMove = false;
            }

            //Player 2 Move
            while(validMove == false)
            {
                //Get user input
                System.out.print("Player 2, select a column to move in: ");
                playerMove = in.nextInt();

                //Check if move is ok
                if(moveOK(playerMove, board))
                {
                    validMove = true;
                    makeMove(playerMove-1, 2, board);
                }
            }
            
            //Check if game is over
            if(checkGameOver(board))
            {
                gameRunning = false;
            }
            else
            {
                validMove = false;
            }
        }
        System.out.println("Game Over");
}
    //Checks if the game is over
    public static boolean checkGameOver(Board boardIn)
    {
        //Declare and initialize variables
        int x = 0;
        int y = 0;
        boolean endCondtionFound = false;

        //Run Win Checks
        while(!endCondtionFound)
        {
            //Runs checks depending on which directions the tile can win in
            if(boardIn.getTile(x, y) != 0)
            {
                //Will check if there is a horizontal win to the right from our current tile if there is three tiles to the right
                if(x+3 < 7)
                {
                    if(winCheckHorizontal(x, y, boardIn.getTile(x, y), boardIn, 1))
                    {
                        System.out.printf("%s %d %s%n", "Player",boardIn.getTile(x, y),"wins!");
                        return true;
                    }
                }
                //Will check for vertical wins if there is at least three tiles above our tile
                if(y+3 < 7)
                {
                    if(winCheckVertical(x, y, boardIn.getTile(x, y), boardIn, 1))
                    {
                        System.out.printf("%s %d %s%n", "Player",boardIn.getTile(x, y),"wins!");
                        return true;
                    }
                }
                //Will check for upwards diagonal wins as long as there are three tiles free up and right
                if(x<4&&y<4)
                {
                    if(winCheckDiagonal1(x, y, boardIn.getTile(x, y), boardIn, 1))
                    {
                        System.out.printf("%s %d %s%n", "Player",boardIn.getTile(x, y),"wins!");
                        return true;
                    }
                }
                //Will check for downwards diagonal wins as long as there are three tiles free down and right
                if(x<4&&y>2)
                {
                    if(winCheckDiagonal2(x, y, boardIn.getTile(x, y), boardIn, 1))
                    {
                        System.out.printf("%s %d %s%n", "Player",boardIn.getTile(x, y),"wins!");
                        return true;
                    }
                }
            }
            
            //If we are at the last tile return false, no game found
            if(x==6&&y==6)
            {
                return false;
            }
            //Else we move a tile over, then up if at the end
            else if(x != 6)
            {
                x++;
            }
            else if(x==6 && y!=6)
            {
                x = 0;
                y++;
            }
        }
        return false;
    }
    //Checks if there is a win to the horizontal to the right from a given x, y tile
    public static boolean winCheckHorizontal(int x, int y, int playerNum, Board boardIn, int inARow)
    {
        if(inARow == 4)
        {
            return true;
        }
        else
        {
            if(boardIn.getTile(x+1, y) == playerNum)
            {
                return winCheckHorizontal(x+1, y, playerNum, boardIn, inARow+1);
            }
            else
            {
                return false;
            }
        }
    }
    //Checks if there is a win upward from a given x, y tile
    public static boolean winCheckVertical(int x, int y, int playerNum, Board boardIn, int inARow)
    {
        if(inARow == 4)
        {
            return true;
        }
        else
        {
            if(boardIn.getTile(x, y+1) == playerNum)
            {
                return winCheckVertical(x, y+1, playerNum, boardIn, inARow+1);
            }
            else
            {
                return false;
            }
        }
    }
    //Checks if there is a win Diagonal going up right
    public static boolean winCheckDiagonal1(int x, int y, int playerNum, Board boardIn, int inARow)
    {
        if(inARow == 4)
        {
            return true;
        }
        else
        {
            if(boardIn.getTile(x+1, y+1) == playerNum)
            {
                return winCheckDiagonal1(x+1, y+1, playerNum, boardIn, inARow+1);
            }
            else
            {
                return false;
            }
        }
    }
    //Checks if there is a win Diagonal going down right
    public static boolean winCheckDiagonal2(int x, int y, int playerNum, Board boardIn, int inARow)
    {
        if(inARow == 4)
        {
            return true;
        }
        else
        {
            if(boardIn.getTile(x+1, y-1) == playerNum)
            {
                return winCheckDiagonal2(x+1, y-1, playerNum, boardIn, inARow+1);
            }
            else
            {
                return false;
            }
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
        //Declare and initialize variables
        int row = 7;
        boolean moveOk = true;

        //Make the move
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
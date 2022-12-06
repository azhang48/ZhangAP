import java.util.Scanner;

public class PA5
{
    public static void main(String[] args)
    {
        Board test = new Board();

        test.setTile(0, 0, 4);
        test.setTile(3, 4, 1);
        test.setTile(5, 4, 2);
        test.printBoard();
    }
}
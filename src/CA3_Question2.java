import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Point> stack = new Stack<>(); //stack to store coordinates
        stack.push(new Point(r,c)); //pushing starting point provided by user, onto the stack

        int fill = 1; // starts with 1 to keep cells in numerical order when filled

        //looping until stack is empty
        while (!stack.isEmpty())
        {
            Point currentCell = stack.pop();
            int row = currentCell.row;
            int col = currentCell.col;

            //Checking if the cell is equal to 0
            if (arr[row][col] == 0)
            {
                arr[row][col] = fill++; // if the cell is 0, we fill it with (1,2,3...etc), showing the order in which they are filled

                //checks if there are neighbouring cells that are unfilled and pushes them onto the stack
                if (row-1 >=0) {
                    Point northCell = new Point(row-1, col);
                    stack.push(northCell);
                }
                if (row+1 <10) {
                    Point southCell = new Point(row+1, col);
                    stack.push(southCell);
                }
                if (col+1 <10) {
                    Point eastCell = new Point(row, col+1);
                    stack.push(eastCell);
                }
                if (col-1 >=0) {
                    Point westCell = new Point(row, col-1);
                    stack.push(westCell);
                }
            }
        }
    }

    //this class is a template for creating a point (coordinate) by using row and column
    public static class Point
    {
        int row;
        int col;
        public Point(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    //method that prompts user and starts the fill method
    public static void start() {
        int[][] arr = floodFillStart(); //creating the 2d array
        Scanner scanner = new Scanner(System.in);

        //Loop used to check if the right dimensions are provided, if not user is prompted again
        while (true)
        {
            System.out.println("Enter the Row you want to start with:");
            int startRow = scanner.nextInt();
            System.out.println("Enter the Column you want to start with:");
            int startCol = scanner.nextInt();

            // checking if the entered row and column are within the valid range
            if (startRow < 1 || startRow >= 10 || startCol < 1 || startCol >= 10)
            {
                System.out.println("Error. Row or Column dimensions are not valid. Please enter values within the 10x10 dimension.\n");
            }
            else
            {
                fill(startRow, startCol, arr); // calling the fill method

                System.out.println("----------   Array filled    -----------");
                display(arr); // Display the filled array
                break; //exiting the loop since the dimensions were correct
            }
        }
    }
    public static void main(String[] args)
    {
        start();
    }

}

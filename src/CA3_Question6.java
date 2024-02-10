
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Queue<Block> shares = new LinkedList<>(); //storing shares
        Scanner in = new Scanner(System.in);
        String command="";

        //looping until user inputs quit
            do {
            System.out.println("Commands List: ");
            System.out.println("[buy <quantity> <price>] to buy shares");
            System.out.println("[sell <quantity> <price>] to sell shares and calculate gain");
            System.out.println("[quit] to finish the simulation");
            System.out.print(">");
            command = in.next();

            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares.add(new Block(qty, price)); //adds a new block to the shares queue
                System.out.println(qty + " shares bought at $" + price + " each");
            }
            else if(command.equalsIgnoreCase("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double profit = 0;

                //checking if there are shares to sell
                while (qty > 0)
                {
                    //getting the current block of shares
                    Block currentShares = shares.peek();

                    //if the user has no more stock to sell, displays a msg and breaks the loop
                    if(currentShares == null)
                    {
                        System.out.println("You have no stock left");
                        break;
                    }

                    //getting the current quantity and price of the current block
                    int boughtQty = currentShares.getQuantity();
                    double sellPrice = currentShares.getPrice();

                    if (qty == boughtQty)
                    {
                        //if the quantity the user inputed is equal to the entire block, then sells everything in one go
                        profit += boughtQty * (price - sellPrice);
                        shares.remove();
                    }
                    else if(qty < boughtQty)
                    {
                        //if the quantity the user inputed is less than the entire block, then sell the shares in parts
                        profit += qty * (price - sellPrice);
                        currentShares.setQuantity(boughtQty - qty); //updates the current shares to the remainder
                        qty = 0; //sets quantity back to zero so it doesnt stack
                    }

                }
                System.out.println("Your profit: " + "$" + profit + "\n");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}

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
        Queue<Block> shares = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String command="";

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
                shares.add(new Block(qty, price));
                System.out.println(qty + " shares bought at $" + price + " each!");
            }
            else if(command.equalsIgnoreCase("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();



            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
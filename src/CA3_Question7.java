import java.util.*;

/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 */
public class CA3_Question7 {

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Map<String, Queue<Block>> shares = new HashMap<>(); // Map to manage shares of multiple companies
        Scanner in = new Scanner(System.in);
        String command = "";

        //looping until user inputs quit
        do {
            System.out.println("\n-------------------------------------------");
            System.out.println("[buy <company> <quantity> <price>] to buy shares");
            System.out.println("[sell <company> <quantity> <price>] to sell shares and calculate gain");
            System.out.println("[quit] to finish the simulation");
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

                //if company doesnt exist in the map yet, create a new list to store the companies shares in
                if(!shares.containsKey(company))
                {
                    shares.put(company, new LinkedList<>());
                }

                shares.get(company).add(new Block(qty, price)); //adding a new block of shares to the company

                System.out.println(qty + " shares from " + company + " bought at $" + price + " each");
            }
            else if (command.equalsIgnoreCase("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                double profit = 0;

                // checking if the company exists in the map, if it doesnt it will let the user know
                if (shares.containsKey(company)) {
                    Queue<Block> companyShares = shares.get(company); //getting the queue of shares from the company inputed

                    //checking if there are shares to sell
                    while (qty > 0) {
                        //getting the current block of shares
                        Block currentShares = companyShares.peek();

                        //if the user has no more stock to sell, displays a msg and break the loop
                        if (currentShares == null) {
                            System.out.println("You have no stock left");
                            break;
                        }

                        //getting the current quantity and price of the current block
                        int boughtQty = currentShares.getQuantity();
                        double boughtPrice = currentShares.getPrice();

                        if (qty == boughtQty) {
                            //if the quantity the user inputed is equal to the entire block they bought, then sell everything in one go
                            profit += boughtQty * (price - boughtPrice);
                            companyShares.remove();
                        } else if (qty < boughtQty) {
                            //if the quantity the user inputed is less than the entire block they bought, then sell the shares in parts
                            profit += qty * (price - boughtPrice);
                            currentShares.setQuantity(boughtQty - qty); //updates the current shares to the remainder
                            qty = 0; //sets quantity back to zero so it doesnt stack
                        }

                    }
                }
                else
                {
                    System.out.println("you don't have any shares for " + company);
                }

                System.out.println("Your profit: " + "$" + profit);
            }

        } while (!command.equalsIgnoreCase("quit"));
    }
}
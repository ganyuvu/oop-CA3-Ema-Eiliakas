import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 *  used https://www.geeksforgeeks.org/queue-interface-java/ to understand using Queues more
 */

public class CA3_Question5
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> landings = new LinkedList<>();
        Queue<String> takeOffs = new LinkedList<>();

        String flightSymbol;
        boolean simRunning = true;

        System.out.println("Commands list: ");
        System.out.println("[takeOff <flightSymbol>] to queue plane");
        System.out.println("[land <flightSymbol>] to queue plane");
        System.out.println("[Next] to complete takeoff/landing ");
        System.out.println("[Quit] to finish the simulation");

        //while true, run simulation
        while (simRunning)
        {
            //Taking in user input and turning it to lower case so that even if command is entered in caps it will work
            System.out.println("\nEnter command: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.contains("takeoff"))
            {
                //removing the first 7 characters (takeoff and any spaces/tab)+ stores it in flightSymbol variable
                flightSymbol = userInput.substring(7).trim();
                takeOffs.add(flightSymbol);
                System.out.println(flightSymbol + " queued for takeoff.");
            }
            else if (userInput.contains("land"))
            {
                flightSymbol = userInput.substring(4).trim();
                landings.add(flightSymbol);
                System.out.println(flightSymbol + " queued for landing.");
            }
            else if (userInput.equals("next")) {
                //checking if the landings queue is empty first as we are prioritizing landings over takeoffs
                //.poll() retrieves the first plane on the que and removes it from the que simultaneously
                if (!landings.isEmpty()) {
                    System.out.println("Landing of " + landings.poll() + " has been completed.");
                } else if (!takeOffs.isEmpty()) {
                    System.out.println("Takeoff for " + takeOffs.poll() + " has been completed.");
                } else {
                    System.out.println("There are no flights in queue.");
                }
            }
            else if(userInput.contains("quit"))
            {
                simRunning = false;
            }

        }
    }
}

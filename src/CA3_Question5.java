import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *  Name:
 *  Class Group: GD2a
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Queue<String> landings = new LinkedList<>();
        Queue<String> takeOffs = new LinkedList<>();

        System.out.println("Commands list: ");
        System.out.println("[takeOff <flightSymbol>] to queue plane");
        System.out.println("[land <flightSymbol>] to queue plane");
        System.out.println("[Next] to complete takeoff/landing ");
        System.out.println("[Quit] to finish the simulation");

        String userInput = scanner.nextLine().toLowerCase();

        if (userInput.contains("takeoff"))
        {
            String flightSymbol = userInput.substring(7).trim();
            takeOffs.add(flightSymbol);
        }
        else if(userInput.contains("land"))
        {
            String flightSymbol = userInput.substring(4).trim();
            landings.add(flightSymbol);
        }

    }
}

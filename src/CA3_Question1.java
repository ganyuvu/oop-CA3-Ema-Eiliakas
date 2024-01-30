/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 */
import java.util.Stack;
import java.util.Scanner;

public class CA3_Question1
{
    public static void runSimulation()
    {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        boolean simRunning = true;

        System.out.println("------Welcome to the Parking Simulation------\n");
        System.out.println("[Enter a positive number to add a car]");
        System.out.println("[Enter a negative number to retrieve a car]");
        System.out.println("[Enter 0 to stop the simulation]");

        while (simRunning)
        {
            int input = scanner.nextInt();

            //This will add a car to the driveway
            if (input > 0)
            {
                driveway.push(input);
                System.out.println("Succesfully added car " + input + " to the driveway");
            }

            //this will retrieve a car from the driveway
            else if (input < 0)
            {
                int carBeingRetrieved = input * -1;
                retrieveCar(driveway, street, carBeingRetrieved);
                System.out.println("Succesfully retrieved car " + input);
            }
            //this will stop the simulation
            else
            {
                simRunning = false;
            }

            //Updating the driveway stack after oporation is done
            System.out.println("Cars in driveway: " + driveway);
        }
    }

    public static void retrieveCar(Stack<Integer> driveway, Stack<Integer> street, int carBeingRetrieved) {
        // moving the cars blocking the car we want to retrieve
        while (!driveway.isEmpty())
        {
            int car = driveway.pop();
            street.push(car);

            //if the car is found we stop moving cars to the street
            if (car == carBeingRetrieved)
            {
                street.pop();
                break;
            }
            System.out.println("Car: " + car + " has been moved to the street: [Street]:" + street);
        }

        // moving the other cars back to the driveway
        while (!street.isEmpty()) {
            driveway.push(street.pop());
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}

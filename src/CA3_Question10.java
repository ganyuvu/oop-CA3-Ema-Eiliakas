import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 */
public class CA3_Question10
{
    public static void main(String[] args) throws FileNotFoundException {
        //storing shortest distances from the first city to other cities
        HashMap<String, Integer> shortestDistances = new HashMap<>();
        // storing connections between cities, each city has a list of its connected cities and their distances
        HashMap<String, HashSet<DistanceTo>> connections = new HashMap<>();
        //priorityQueue keeps DistanceTo objects in order based on their distances
        PriorityQueue<DistanceTo> priorityQueue = new PriorityQueue<>();

        Scanner scanner = new Scanner(new File("cities.txt"));
        String startingCity = "Pendleton";

        // adding cities + distances from txt file to the map
        while (scanner.hasNext())
        {
            String city1 = scanner.next();
            String city2 = scanner.next();
            int distance = scanner.nextInt();

            //if city1 isnt in the map we add it to the map with an empty hashset
            if (!connections.containsKey(city1))
            {
                connections.put(city1, new HashSet<>()); //the empty HashSet will be used to store the connections with city1
            }
            // getting HashSet that matches city1 from the connections map and adding new DistanceTo object to it
            //this DistanceTo object shows the connection between city1 and city2 and the distance between
            connections.get(city1).add(new DistanceTo(city2, distance));
        }
        //starting the queue with the first city in the file
        priorityQueue.offer(new DistanceTo(startingCity, 0));

        while(priorityQueue.size()!=0)
        {
            //getting the smallest DistanceTo object in the queue
            DistanceTo smallest = priorityQueue.poll();

            // checking if we already know the shortest distance to the city the priorityQueue leads to
            if (!shortestDistances.containsKey(smallest.getTarget()))
            {
                // if not get the distance of the smallest object
                int shortestDistance = smallest.getDistance();
                //add to shortestDistances map, the key is the target city obtained from smallest, and the value is the shortest distance to that target
                shortestDistances.put(smallest.getTarget(), shortestDistance);

                // for each connection of the target city, add new DistanceTo objects to the priority queue
                for (DistanceTo connection : connections.get(smallest.getTarget()))
                {
                    // calculate the total distance from the starting city to the connected city and add to queue
                    priorityQueue.add(new DistanceTo(connection.getTarget(), shortestDistance + connection.getDistance()));
                }
            }
        }
        // printing shortest route from the starting city to each city
        for(String city : shortestDistances.keySet())
        {
            //we dont include the starting city
            if(!(city.equals(startingCity)))
            {
                System.out.println(city + "'s shortest route from " + startingCity + ": "+ shortestDistances.get(city));
            }
        }
    }
}

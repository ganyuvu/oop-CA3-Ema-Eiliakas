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
        Map<String, TreeSet<DistanceTo>> map = new HashMap<>();
        HashMap<String, HashSet<DistanceTo>> distances = new HashMap<>();
        PriorityQueue<DistanceTo> priorityQueue = new PriorityQueue<>();

        Scanner scanner = new Scanner(new File("cities.txt"));
        String startingCity = scanner.next(); //this retrieves the first city from the file

        // adding cities + distances from txt file to the map
        while (scanner.hasNext()) {
            String city1 = scanner.next();
            String city2 = scanner.next();
            int distance = scanner.nextInt();

            if (!distances.containsKey(city1)) {
                distances.put(city1, new HashSet<>());
            }
            distances.get(city1).add(new DistanceTo(city2, distance));
        }
        //starting the queue with the first city in the file
        priorityQueue.offer(new DistanceTo(startingCity, 0));

    }
}

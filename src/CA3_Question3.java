import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *  Name:Ema Eiliakas
 *  Class Group: GD2a
 */

public class CA3_Question3 {
    public static void readFile(String fileName) throws FileNotFoundException {
        //creating a map to store the identifiers and the line number they are on
        Map<String, ArrayList<Integer>> identifiers = new HashMap<>();
        Scanner in = new Scanner(new File(fileName)); //Reading the file in fileName method
        in.useDelimiter("[^A-Za-z0-9_]+"); // creating delimiter so that scanner can split the identifiers

        String line, identifier;
        int countLine = 0;

        //looping through the file
        while (in.hasNextLine()) {
            countLine++; //keeping track of which line is being read
            line = in.nextLine(); //reads next line

            Scanner lineScan = new Scanner(line); //creating another scanner to scan each line for any identifiers

            //Looping through each identifier in a line
            while (lineScan.hasNext()) {
                identifier = lineScan.next();
                //checking if identifier is in the map, if not it will add it to the map
                if (!identifiers.containsKey(identifier)) {
                    identifiers.put(identifier, new ArrayList<>());
                }
                identifiers.get(identifier).add(countLine); //adding current line num to the map and match to the identifier
            }
        }

        // printing identifiers and the line they occur in
        for (Map.Entry<String, ArrayList<Integer>> entry : identifiers.entrySet())
        {
            System.out.print(entry.getKey() + " | "); //printing the identifier
            List<Integer> lineNumbers = entry.getValue(); //getting the line number of the identifier

            //looping through all the lineNumbers
            for (int i = 0; i < lineNumbers.size(); i++)
            {
                System.out.print(lineNumbers.get(i)); //printing the current line number according to the list
                //checking if the current line number is not last in the list in case an identifier appears on multiple lines
                if (i < lineNumbers.size() - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println("\n");
        }
    }
    public static void main (String[]args) throws FileNotFoundException {
            readFile("src/CA3_Question1.java");
        }
    }


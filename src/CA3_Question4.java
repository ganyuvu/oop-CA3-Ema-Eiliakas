import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Ema Eiliakas
 *  Class Group: GD2a
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filename)); //reading the file
        Stack<String> tags = new Stack<>(); //stack that will store html tags

        //Going through the file
        while (in.hasNext())
        {
            String tag = in.next(); //reading the next tag
            if (!tag.contains("/")) //if tag doesnt contain "/" its an opening tag
            {
                tags.push(tag); //opening tag pushed to the tags stack
            }
            //checking if opening tag has a closing tag
            else
            {
                //if the tags stack is empty it means it all opening tags have been properly closed
                //if the stack isnt empty it compares the closing tag to the last opening tag that was added to the stack
                if (tags.isEmpty() || !tag.substring(2).equals(tags.pop().substring(1)))
                {
                    return false; //returns false if there is a mismatch
                }
            }
        }
        return tags.isEmpty(); // double checking if any tags are left
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}

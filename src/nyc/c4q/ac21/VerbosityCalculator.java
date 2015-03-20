package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args){

        // An abstract representation of a File
        File Dickens = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Charles_Dickens'_A_Tale_of_Two_Cities.txt");
        File Melville = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Hermal Melville's Moby Dick.txt");

        //count the words
        try{
            Scanner readDickens = new Scanner(Dickens);
            Scanner readMelville = new Scanner(Melville);

            int countWords = 0;
            String story = "";

            while (readDickens.hasNext()) {
                story = readDickens.next();
                countWords++;
            }

            System.out.println(countWords);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

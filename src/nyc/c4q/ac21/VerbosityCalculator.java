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
        File dickens = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Charles_Dickens'_A_Tale_of_Two_Cities.txt");
        File melville = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Hermal Melville's Moby Dick.txt");

        
        countWord(dickens);
        countSentence(dickens);
        countWord(melville);
        countSentence(melville);


    }


    //count the words
    public static void countWord (File file) {
        try {
            Scanner read = new Scanner(file);

            int countWords = 0;
            String story = "";

            while (read.hasNext()) {
                story = read.next();
                countWords++;
            }

            System.out.println(countWords);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //count the sentence
    public static void countSentence (File file) {
        try {
            Scanner read = new Scanner(file);

            int countSentence = 0;
            String story = "";

            while (read.hasNextLine()) {
                story = read.nextLine();
                countSentence++;
            }

            System.out.println(countSentence);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

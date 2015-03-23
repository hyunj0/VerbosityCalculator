package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*************************************
 * Calculate the verbosity of a text *
 *************************************/

public class VerbosityCalculator {
    public static void main(String[] args) {

        // An abstract representation of a File
        File dickens = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Charles Dickens' A Tale of Two Cities.txt");
        File melville = new File("/Users/c4q-sarahkim/Desktop/accesscode/VerbosityCalculator/resources/Hermal Melville's Moby Dick.txt");

        System.out.println("Charles Dickens' A Tale of Two Cities has ");
        verbosity(dickens);

        System.out.println("Hermal Melville's Moby Dick has ");
        verbosity(melville);

        // After reviewing the verbosity of the two authors,
        System.out.println("Hermal Melville is more verbose");
    }

    //method to count the total words in the text files
    public static int totalWords (File file) {
        try {
            //use Scanner to scan through the file
            Scanner sc = new Scanner(file);

            //initialize empty string
            String text = "";

            //initialize counter
            int countWords = 0;

            //scan the file and whenever you hit a space the default delimiter telling the .hasNext to stop scanning
            //add it to your text string and add 1 to your word count
            //repeat until the end
            while (sc.hasNext()) {
                text = sc.next();
                countWords += 1;
            }
            return countWords;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //method to count the total sentences in the text file
    public static int totalSentences (File file) {
        try {
            Scanner sc = new Scanner(file);
            String text = "";
            int countSentences = 0;

            //as opposed to scanning through the whole file, scan line by line
            while (sc.hasNextLine()) {
                text = sc.nextLine();
                //if the line has a period, exclamation mark, or question mark then you know that ends a sentence
                if (text.contains(".") || text.contains("!") || text.contains("\\?")) {
                    countSentences += 1;
                //if the period is for a salutation then you don't include it to your sentence count
                } else if (text.contains("Dr.") || text.contains("Mr.") || text.contains("Mrs.") || text.contains("Ms.")) {
                    continue;
                } else {
                    continue;
                }
            }
            return countSentences;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void verbosity (File file) {
        //format number to have commas and decimals
        NumberFormat decimal = new DecimalFormat("###,###.##");

        System.out.println("total word count of " + decimal.format(totalWords(file)));
        System.out.println("total sentence count of " + decimal.format(totalSentences(file)));

        double verbosityIs = ((double) totalWords(file)) / ((double) totalSentences(file));

        System.out.println("Verbosity = " + decimal.format(verbosityIs) + "\n");
    }
}
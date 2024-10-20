package ch.heigvd.dai.sort_type.ios;

import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Class to write the dictionary into the output file(a markdown file for better readability, rather than a text file)
 */
public class File_writer {
    public static void output_generator(String filename, String used_sort, Map<String, Integer> word_list) {

        //try-with-resources to catch errors with the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".dictionary.md", StandardCharsets.UTF_8))) {

            //Write the description of the dictionary
            bw.write("# Dictionary of " + filename + "\n");
            bw.write("# Used sort : " + used_sort + "\n");

            //Write the name of the columns for the array
            bw.write("# Word List : \n");
            bw.write("| Words | Apparition count |\n");
            bw.write("|---|---|\n");

            //Write all the words in the array
            for (Map.Entry<String, Integer> entry : word_list.entrySet()) {
                bw.write("| " + entry.getKey() + " | " + entry.getValue() + " |\n");
            }

            //Flush to empty the buffer
            bw.flush();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

package ch.heigvd.dai.sort_type.ios;

import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class uses a static method to write the map(dictionary) in an output file using
 * the Markdown format for better readability rather than a text file.
 * This implementation writes the file using a buffered writer around a file writer.
 * The writing process is secured with a try-with-resources.
 *
 * @author Alex Berberat
 * @author Lisa Gorgerat
 */
public class File_writer {

    /**
     * Output generator generate a file containing the final dictionary.
     *
     * @param filename  the name of the original file.
     * @param used_sort the used sort.
     * @param word_list the word list.
     */
    public static void output_generator(String filename, String used_sort, Map<String, Integer> word_list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".dictionary.md", StandardCharsets.UTF_8))) {

            // Writes the description of the dictionary.
            bw.write("# Dictionary of " + new File(filename).getName() + "\n");
            bw.write("# Used sort : " + used_sort + "\n");

            // Writes the name of the columns for the array.
            bw.write("# Word List : \n");
            bw.write("| Words | Apparition count |\n");
            bw.write("|---|---|\n");

            // Writes all the words and apparition count in the array.
            for (Map.Entry<String, Integer> entry : word_list.entrySet()) {
                bw.write("| " + entry.getKey() + " | " + entry.getValue() + " |\n");
            }

            // Flush to empty the buffer.
            bw.flush();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

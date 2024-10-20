package ch.heigvd.dai.sort_type.ios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class uses a static method to reads the input file and convert it into a map(dictionary).
 * This implementation reads the file using a buffered reader around a file reader.
 * The reading process is secured with a try-with-resources.
 *
 * @author Alex Berberat
 * @author Lisa Gorgerat
 */
public class File_reader {

    /**
     * Words extractor extracts each word from the file and put them in a map while counting
     * how many times they appear.
     *
     * @param filename the name of the file to convert.
     * @return the map containing every word.
     */
    public static Map<String, Integer> words_extractor(String filename) {

        Map<String, Integer> words_list = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {

            while ((br.ready())) {
                String line = br.readLine();

                /*
                 * Remove all punctuation and number in the text.
                 * \p{Punct} is a POSIX pattern.
                 * \p{IsPunctuation} is a UNICODE pattern.
                 * Both are needed because de UNICODE pattern doesn't match all the characters
                 * matched by the POSIX pattern.
                 * \d is for the numbers.
                 */
                line = line.replaceAll("\\p{Punct}|\\p{IsPunctuation}|\\d", " ");

                // Replace consecutive space by a unique space.
                line = line.trim().replaceAll(" +", " ");

                // Continue to next iteration if the string contains no characters.
                if (line.isBlank()) {
                    continue;
                }

                // Convert all lettres to lower case, as we are making a case-insensitive dictionary.
                line = line.toLowerCase();

                // Extract each word and insert them in the Map while increasing the counter if necessary.
                for (String word : line.split(" ")) {
                    if (words_list.containsKey(word)) {
                        words_list.put(word, words_list.get(word) + 1);
                    } else {
                        words_list.put(word, 1);
                    }
                }
            }

        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return words_list;
    }
}

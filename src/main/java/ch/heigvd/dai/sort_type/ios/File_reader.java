package ch.heigvd.dai.sort_type.ios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Class to read the inputed file and make it into a Map(dictionary)
 */
public class File_reader {
    public static Map<String, Integer> words_extractor(String filename) {

        //Map<String, Integer> words_list = new HashMap<>();
        Map<String, Integer> words_list = new LinkedHashMap<>();

        //try-with-resources to catch errors with the input file
        try (BufferedReader br = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {

            while ((br.ready())) {
                String line = br.readLine();

                //Remove all punctuation in the text
                line = line.replaceAll("\\p{Punct}|\\p{IsPunctuation}|\\d", " ");

                //Replace remaining symbols by space
                line = line.trim().replaceAll(" +", " ");

                //Skip the spaces
                if (line.isBlank()) {
                    continue;
                }

                //Convert all lettres to lower case, as we are making a case-insensitive dictionary
                line = line.toLowerCase();

                //Insert the now defined word into the Map
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

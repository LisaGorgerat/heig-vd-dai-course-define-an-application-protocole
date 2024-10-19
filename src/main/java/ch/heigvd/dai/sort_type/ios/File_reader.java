package ch.heigvd.dai.sort_type.ios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class File_reader {
    public static Map<String, Integer> words_extractor(String filename) {

        //Map<String, Integer> words_list = new HashMap<>();
        Map<String, Integer> words_list = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {

            while ((br.ready())) {
                String line = br.readLine();


                line = line.replaceAll("\\p{Punct}|\\p{IsPunctuation}|\\d", " ");


                line = line.trim().replaceAll(" +", " ");

                if (line.isBlank()) {
                    continue;
                }

                line = line.toLowerCase();

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

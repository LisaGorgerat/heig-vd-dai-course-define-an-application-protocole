package ch.heigvd.dai.sort_type.ios;

import java.util.Map;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class File_writer {
    public static void output_generator(String filename, String used_sort, Map<String, Integer> word_list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".dictionary.md", StandardCharsets.UTF_8))) {

            bw.write("# Dictionary of " + filename + "\n");
            bw.write("# Used sort : " + used_sort + "\n");

            bw.write("# Word List : \n");
            bw.write("| Words | Apparition count |\n");
            bw.write("|---|---|\n");

            for (Map.Entry<String, Integer> entry : word_list.entrySet()) {
                bw.write("| " + entry.getKey() + " | " + entry.getValue() + " |\n");
            }


            bw.flush();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

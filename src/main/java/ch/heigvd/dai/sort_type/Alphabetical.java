package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

import java.util.Map;
import java.util.TreeMap;

public class Alphabetical implements Sortable {
    @Override
    public void sort(String filename) {

        Map<String, Integer> sorted_words = new TreeMap<>(File_reader.words_extractor(filename));

        File_writer.output_generator(filename, "Alphabetical", sorted_words);
    }
}

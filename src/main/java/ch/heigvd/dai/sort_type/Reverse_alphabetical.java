package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Reverse_alphabetical implements Sortable {
    @Override
    public void sort(String filename) {



        Map<String, Integer> sorted_words = new TreeMap<>(Comparator.reverseOrder());
        sorted_words.putAll(File_reader.words_extractor(filename));


        File_writer.output_generator(filename, "Reverse Alphabetical", sorted_words);

    }
}

package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class implements the usage sort which sorts based on the number
 * of time a word is used.
 *
 * @author Alex Berberat
 * @author Lisa Gorgerat
 */
public class Usage implements Sortable {
    @Override
    public void sort(String filename) {

        Map<String, Integer> words_list = File_reader.words_extractor(filename);

        // Sort the map by value - source: https://howtodoinjava.com/java/sort/java-sort-map-by-values/
        Map<String, Integer> sorted_words = words_list.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        File_writer.output_generator(filename, "Usage", sorted_words);
    }
}

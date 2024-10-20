package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class implements the alphabetical sort by converting the Map into a TreeMap.
 * The TreeMap sorts automatically during the creation process.
 *
 * @author Alex Berberat
 * @author Lisa Gorgerat
 */
public class Alphabetical implements Sortable {
    @Override
    public void sort(String filename) {

        Map<String, Integer> sorted_words = new TreeMap<>(File_reader.words_extractor(filename));

        File_writer.output_generator(filename, "Alphabetical", sorted_words);
    }
}

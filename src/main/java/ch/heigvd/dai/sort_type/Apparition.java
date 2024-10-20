package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

/**
 * Implementation of the sort by apparition in the text which is the standard sort
 */
public class Apparition implements Sortable {
    @Override
    public void sort(String filename) {

        File_writer.output_generator(filename, "Apparition", File_reader.words_extractor(filename));

    }
}

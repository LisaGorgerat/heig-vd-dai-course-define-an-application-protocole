package ch.heigvd.dai.sort_type;

import ch.heigvd.dai.sort_type.Sortable;
import ch.heigvd.dai.sort_type.ios.*;

public class Apparition implements Sortable {
    @Override
    public void sort(String filename) {

        File_writer.output_generator(filename, "Apparition", File_reader.words_extractor(filename));

    }
}

package ch.heigvd.dai.commands;

import ch.heigvd.dai.sort_type.*;

import java.util.concurrent.Callable;

import picocli.CommandLine;

@CommandLine.Command(name = "sort", description = "Count and sort words from a file.")
public class Sort implements Callable<Integer> {
    @CommandLine.ParentCommand
    protected Root parent;

    @Override
    public Integer call() {
        Sortable sorter =
                switch (parent.getSort()) {
                    case ALPHABETICAL -> new Alphabetical();
                    case REVERSE_ALPHABETICAL -> new Reverse_alphabetical();
                    case USAGE -> new Usage();
                    case APPARITION -> new Apparition();
                };

        System.out.println("Sorting " + parent.getFilename() + " using " + parent.getSort());

        sorter.sort(parent.getFilename());
        return 0;
    }
}

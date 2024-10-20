package ch.heigvd.dai.commands;

import picocli.CommandLine;

/**
 * This class is the root of the CLI.
 * It implements the standard command and definition of its options, parameters and subcommands.
 *
 * @author Alex Berberat
 * @author Lisa Gorgerat
 */
@CommandLine.Command(
        description = "CLI for dictionary creation from a text.",
        version = "1.0.0",
        subcommands = {
                Sort.class,
        },
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true)
public class Root {
    // Definition of the types of sort available
    public enum AvailableInputSort {
        ALPHABETICAL,
        REVERSE_ALPHABETICAL,
        USAGE,
        APPARITION
    }

    // Definition of the parameter for the input file
    @CommandLine.Parameters(index = "0", description = "The name of the file.")
    protected String filename;

    // Definition of the option for the sort
    @CommandLine.Option(
            names = {"-s", "--sort"},
            description = "The sort function to use (possible values ${COMPLETION-CANDIDATES}).",
            required = true)
    protected AvailableInputSort sort;

    public String getFilename() {
        return filename;
    }

    public AvailableInputSort getSort() {
        return sort;
    }
}

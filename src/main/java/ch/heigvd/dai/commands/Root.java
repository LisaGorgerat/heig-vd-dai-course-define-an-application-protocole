package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
        description = "CLI for dictionary creation from a text.",
        version = "1.0.0",
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true)
public class Root {
    public enum AvailableInputSort {
        ALPHABETICAL,
        REVERSE_ALPHABETICAL,
        USAGE,
        APPARITION
    }

    @CommandLine.Parameters(index = "0", description = "The name of the file.")
    protected String filename;

    @CommandLine.Option(
            names = {"-s", "--sort"},
            description = "The sort function for the dictionary.",
            required = true)
    protected AvailableInputSort sort;

    public String getFilename() {
        return filename;
    }

    public AvailableInputSort getSort() {
        return sort;
    }
}

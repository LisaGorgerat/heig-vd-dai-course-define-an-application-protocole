package ch.heigvd.dai;

import ch.heigvd.dai.commands.Root;
import picocli.CommandLine;
import java.io.File;

/**
 * main of the application to initialize a command line and calculate execution time
 */
public class Main {
    public static void main(String[] args) {

        // Define command name - source: https://stackoverflow.com/a/11159435
        String jarFilename =
                new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                        .getName();

        // Create root command
        Root root = new Root();

        // Get user input and execution time
        Long start = System.nanoTime();
        int exitCode =
                new CommandLine(root)
                        .setCommandName(jarFilename)
                        .setCaseInsensitiveEnumValuesAllowed(true)
                        .execute(args);


        if (exitCode == 0) {
            System.out.println("out");
        }

        System.exit(exitCode);
    }
}
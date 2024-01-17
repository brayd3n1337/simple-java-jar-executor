package cn.hackforums;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main {

    /**
     * The folder where the jar file is located.
     *
     * <p>
     *     Default value is {@code System.getProperty("user.home") + "/Downloads"}.
     *     Adjust as needed.
     * </p>
     *
     */
    private static final String DOWNLOADS_FOLDER = System.getProperty("user.home") + "/Downloads";

    /**
     * The name of the jar file to start.
     *
     * <p>
     *     Default value is {@code "testjar.jar"}.
     *     Adjust as needed.
     * </p>
     *
     */
    private static final String JAR_NAME = "testjar.jar";


    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * The {@link ProcessBuilder} used to build our process, it executes the command {@code java -jar testjar.jar} in the {@code DOWNLOADS_FOLDER}.
     */
    private static final ProcessBuilder PROCESS_BUILDER = new ProcessBuilder(
            "java",
            "-jar",
            JAR_NAME
    ).directory(
            new File(
                    DOWNLOADS_FOLDER
            )
    );

    public static void main(final String[] args) {
        try {
            PROCESS_BUILDER.start();
        } catch (final IOException ioException) {
            LOGGER.log(Level.SEVERE, "Failed to start the jar file.", ioException);
        }
    }
}
/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public final class ROM {

    // ROM SETTINGS

    public static final @Unmodifiable @NotNull String TERMINAL_VERSION = "0.0.1";




    // ROM SETTINGS
    // ------------------------------------------------------------
    // COLOR CODES


    public static final @Unmodifiable @NotNull String white = "\u001B[0m";



    public static final @Unmodifiable @NotNull String black = "\u001B[30m";



    public static final @Unmodifiable @NotNull String red = "\u001B[31m";



    public static final @Unmodifiable @NotNull String green = "\u001B[32m";



    public static final @Unmodifiable @NotNull String yellow = "\u001B[33m";



    public static final @Unmodifiable @NotNull String blue = "\u001B[34m";



    public static final @Unmodifiable @NotNull String purple = "\u001B[35m";



    public static final @Unmodifiable @NotNull String cyan = "\u001B[36m";



    public static final @Unmodifiable @NotNull String gray = "\u001B[37m";


    // COLOR CODES
    // ------------------------------------------------------------
    // RAM VARIABLES


    public static volatile @NotNull String workingDirectory = System.getProperty("user.dir");

    public static volatile @NotNull String directory = "";

    public static @NotNull String homeDir = "";

    public static volatile @NotNull String terminal_indent = cyan + "> " + white;



    // RAM VARIABLES
    // ------------------------------------------------------------
    // FUNCTIONS


    public static final Boolean requireDir () {


        if (directory.isEmpty()) {
            System.out.println(red + "Error: " + white + "No directory specified. This command requires a directory.");
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }

    }


    public static final @NotNull String VERSION () {

        /* try {
            FileReader reader = new FileReader(".version");
        } catch (Exception e) {
            return "Error getting version.";
        } */

        return "0.0.1";
    }





    // FUNCTIONS
    // ------------------------------------------------------------

}

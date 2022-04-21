import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.io.File;

public final class ROM {

    // ROM SETTINGS

    public static final @Unmodifiable @NotNull String VERSION = "0.0.2";



    public static final String ROM_STRING = """
            
            horse print "Hello World!"
            
            
            
            """;

    public static final File ROM_FILE = new File("");

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
    // REUSED VARIABLES





    public static final @Unmodifiable @NotNull String console_indent = green + "> " + white;

    public static final @Unmodifiable @NotNull String terminal_indent = cyan + "> " + white;



    // REUSED VARIABLES
    // ------------------------------------------------------------

}

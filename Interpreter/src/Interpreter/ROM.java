/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter;import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import c.c;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public final class ROM {

    // ROM SETTINGS

    public static final @Unmodifiable @NotNull String VERSION = "0.0.2";



    public static final String ROM_STRING = """
            
            horse print "Hello World!"
            
            
            
            """;

    public static final File ROM_FILE = new File("");

    // ROM SETTINGS
    // ------------------------------------------------------------
    // REUSED VARIABLES





    public static final @Unmodifiable @NotNull String console_indent = c.green + "> " + c.white;

    public static final @Unmodifiable @NotNull String terminal_indent = c.cyan + "> " + c.white;



    // REUSED VARIABLES
    // ------------------------------------------------------------
    // FUNCTIONS RUN BY OR FOR HORSESCRIPT LAUNCHER

    public final static void launcher () {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println(c.green + "HorseScript Launcher | HorseScript Version " + Terminal.ROM.VERSION());
        System.out.println(c.blue + "\nHorseScript Utilities");
        System.out.println(c.yellow + "0 - Interpret Line From Scanner");
        System.out.println("1 - Interpret Line from ROM String");
        System.out.println("2 - Interpret File from ROM filepath");
        System.out.println("3 - Open Infinite HorseScript Console");
        System.out.println("4 - Interpret File from Scanner");
        // System.out.println("5 - Interpret File from command line args");
        System.out.print(c.purple + "Enter HorseScript utility: ");
        RAM.useROM = scanner1.nextByte();
    }

    public final static void fileFromScanner () throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print(c.yellow + "\nEnter a filepath to a .hscript file to interpret\n" + c.cyan + " > ");
        String input = scanner.nextLine();
        RAM.toInterpret = new File(input);
        if (RAM.toInterpret.getName().endsWith(".hscript")) {
        } else {
            throw new DataFormatException("File must be a .hscript file");
        }
        Path path = Path.of(RAM.toInterpret.toString());
        String toInput = Files.readString(path);
        Interpreter.interpret(toInput);
    }

    public final static void fileFromString (File file) throws Exception {



        RAM.toInterpret = file;
        if (RAM.toInterpret.getName().endsWith(".hscript")) {
        } else {
            throw new DataFormatException("File must be a .hscript file");
        }
        Path path = Path.of(RAM.toInterpret.toString());
        String toInput = Files.readString(path);
        Interpreter.interpret(toInput);
    }

}

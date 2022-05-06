/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

import resources.HorseError;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.DataFormatException;
import c.c;

public class Main {

    public static void main(String[] args) throws Exception {




        try {

            String action = args[0];


            if (action.equals("5")) {

                try {
                    RAM.toInterpret = new File(args[1]);

                    RAM.useROM = 5;

                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("You need to specify a filepath of a file to interpret");
                    System.out.println("Defaulting to HorseScript Launcher.");
                    ROM.launcher();
                }
            } else if (action.equals("6")) {

                try {

                    RAM.txtInterpret = args[1];


                    for (int i = 2; i < args.length; i++) {

                        RAM.txtInterpret += " " + args[i];

                    }


                    RAM.useROM = 6;

                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("You need to specify a line of code to interpret.");
                    System.out.println("Defaulting to HorseScript Launcher.");
                    ROM.launcher();
                }

            } else {
               RAM.useROM = (byte) Integer.parseInt(action);
            }



        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(c.gray + "No command line args specified, defaulting to HorseScript Launcher.");
            ROM.launcher();
        }






    switch (RAM.useROM) {
        case 0 -> {
            Scanner scanner2 = new Scanner(System.in);
            String input = scanner2.nextLine();
            Interpreter.interpret(input);
        }
        case 1 -> {
            Interpreter.interpret(ROM.ROM_STRING);
        }
        case 2 -> {
            if (ROM.ROM_FILE.getName().endsWith(".hscript")) {
                String input;
                Path path = Path.of(ROM.ROM_FILE.toString());
                input = Files.readString(path);
                Interpreter.interpret(input);
            } else {
                throw new DataFormatException("File must be a .hscript file");
            }
        }
        case 3 -> {
            Console.main(null);
        }
        case 4 -> {
            ROM.fileFromScanner();
        }
        case 5 -> {
            ROM.fileFromString(RAM.toInterpret);
        }
        case 6 -> {
            Interpreter.interpret(RAM.txtInterpret);
        }
        default -> {
            throw new HorseError("[HorseScript] Unexpected value: " + RAM.useROM);
        }



    }


    }



}

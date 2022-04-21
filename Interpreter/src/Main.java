import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.DataFormatException;

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
            }



        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(ROM.gray + "No command line args specified, defaulting to HorseScript Launcher.");
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
        default -> {
            throw new IllegalStateException("Unexpected value: " + RAM.useROM);
        }



    }


    }



}

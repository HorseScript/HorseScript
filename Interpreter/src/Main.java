import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    public static void main(String[] args) throws Exception {




    Scanner scanner1 = new Scanner(System.in);
    System.out.println(ROM.green + "HorseScript Launcher | HorseScript Version " + ROM.VERSION);
        System.out.println(ROM.blue + "\nHorseScript Utilities");
        System.out.println(ROM.yellow + "0 - Interpret Line From Scanner");
        System.out.println("1 - Interpret Line from ROM String");
        System.out.println("2 - Interpret File from ROM filepath");
        System.out.println("3 - Open Infinite HorseScript Console");
        System.out.print(ROM.purple + "Enter HorseScript utility: ");

        RAM.useROM = scanner1.nextByte();


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
        default -> {
            throw new IllegalStateException("Unexpected value: " + RAM.useROM);
        }



    }


    }

}

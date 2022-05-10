/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal;import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.UUID;


public class Terminal {



    public static void main(String[] args) throws Exception {

        System.out.println(ROM.purple + "\n\n\nHorseScript Terminal | Version " + ROM.TERMINAL_VERSION + "\n" + ROM.white);

        RunTerm();




    }


    protected static void RunTerm () throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print(ROM.terminal_indent);
            String eval = scanner.nextLine();
            evaluate_terminal(eval);





        }
    }


    protected static void evaluate_terminal (@NotNull String input) throws Exception {

        if (input.equals("")) {
            return;

        } else if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);



        } else if (input.replace(" ", "").equals("eval")) {
            System.out.println("Eval command: eval : <type> = <code>");
            System.out.println("This command will evaluate a line of <type> code.");
            System.out.println("<type> can be replaced with hscript, or any supported dialect.");




        } else if (input.startsWith("eval ")) {
            evaluator(input);


        } else if (input.replace(" ", "").equals("console")) {
            System.out.println("Console command: console : <type>");
            System.out.println("This command will open a <type> console.");
            System.out.println("<type> can be replaced with hscript, or any supported console.");




        } else if (input.startsWith("console ")) {
            console(input);


        } else if (input.startsWith("help")) {
            System.out.println(ROM.purple + "HorseScript Terminal | Version " + ROM.TERMINAL_VERSION + ROM.white);
            System.out.println("Commands:\nexit\neval <code>\nhorse <command>");



        } else if (input.replace(" ", "").equals("horse")) {
            System.out.println("Horse command: horse <run>");
            System.out.println("This command will run a certain a HorseScript project.");



        } else if (input.startsWith("horse ")) {
            horse(input);


        } else if (input.replace(" ", "").equals("dir")) {
            System.out.println("Dir command: dir <directory>");
            System.out.println("This command will change the directory.");


        } else if (input.startsWith("dir ")) {

            ROM.directory = input.replace("dir ", "");
            ROM.terminal_indent = ROM.blue + ROM.directory + ROM.cyan + " > " + ROM.white;



        } else {
            try {
                throw new Error("Unknown command: " + input);
            } catch (Error e) { e.printStackTrace(); Thread.sleep(100); }
        }




    }


    public static void horse (String command) throws IOException {

        String uuid = UUID.randomUUID().toString();
        String cmd2 = command.replaceFirst(" ", uuid);

        String cmd3 = cmd2.replaceAll(" ", "").replaceAll(uuid, " ");

        if (cmd3.equals("horse dist")) {

            if (!ROM.requireDir()) return;

            Files.copy(new File(ROM.workingDirectory + "/Terminal/Interpreter.jar").toPath(),new File(ROM.directory + "/Interpreter.jar").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Runtime.getRuntime().exec("java -jar Interpreter.jar 5 dist/index.hscript", null, new File(ROM.directory));


        }


    }


    public static void evaluator (@NotNull String command) throws Exception {

        String toEval;
        String clean = command.replaceFirst("eval ", "");

        if (!clean.startsWith(": ")) {
            System.out.println("Bad syntax");
            System.out.println("Eval command: eval : <type> = <code>");
        } else {
            clean = clean.replaceFirst(": ", "");
        }

        Scanner scanner = new Scanner(clean);
        String type = scanner.next();

        String code = clean.replaceFirst(type + " = ", "");


        if (type.equals("hscript")) {
            toEval = code.replaceAll("\\\"", "\\\\\"");
        } else {
            System.out.println(type + " is not a supported dialect of HorseScript.");
            System.out.println("Supported dialects: hscript");
            System.out.print("If you want to add this dialect, please see us on GitHub: ");
            System.out.println("https://github.com/HorseScript/HorseScript");
            return;
        }


        Files.copy(new File(ROM.workingDirectory + "/Terminal/Interpreter.jar").toPath(),new File(ROM.directory + "/Interpreter.jar").toPath(), StandardCopyOption.REPLACE_EXISTING);

        Process p = Runtime.getRuntime().exec("java -jar Interpreter.jar 6 " + toEval, null, new File(ROM.directory));

        p.waitFor();

    }


    public static void console (@NotNull String command) throws Exception {

        String toEval;
        String clean = command.replaceFirst("console ", "");

        if (!clean.startsWith(": ")) {
            System.out.println("Bad syntax");
            System.out.println("Console command: console : <type>");
        } else {
            clean = clean.replaceFirst(": ", "");
        }

        Scanner scanner = new Scanner(clean);
        String type = scanner.next();



        if (type.equals("hscript")) {
            // this is good.
        } else {
            System.out.println(type + " is not a supported console of HorseScript.");
            System.out.println("Supported consoles: hscript");
            System.out.print("If you want to add this console, please see us on GitHub: ");
            System.out.println("https://github.com/HorseScript/HorseScript");
            return;
        }


        Files.copy(new File(ROM.workingDirectory + "/Terminal/Interpreter.jar").toPath(),new File(ROM.directory + "/Interpreter.jar").toPath(), StandardCopyOption.REPLACE_EXISTING);

        Process p = Runtime.getRuntime().exec("java -jar Interpreter.jar 3", null, new File(ROM.directory));

        p.waitFor();

    }




}

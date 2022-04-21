import org.jetbrains.annotations.NotNull;

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
            System.out.println("Eval command: eval <code>");
            System.out.println("This command will evaluate a line of HorseScript code.");



        } else if (input.startsWith("eval ")) {
            // TODO: Make this work


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

            Files.copy(new File(ROM.homeDir + "/IdeaProjects/Terminal/InterpreterTerminal.jar").toPath(),new File(ROM.directory + "/InterpreterTerminal.jar").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Runtime.getRuntime().exec("zsh java -jar InterpreterTerminal.jar dist/index.hscript", null, new File(ROM.directory));


        }


    }

}
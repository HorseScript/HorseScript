import java.util.Scanner;

public class Terminal {

    public static final String TERMINAL_VERSION = "0.0.1";

    public static void main(String[] args) {

        System.out.println(ROM.purple + "\n\n\nHorseScript Terminal | Version " + TERMINAL_VERSION);

        RunTerm();




    }

    protected static void RunTerm () {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print(ROM.terminal_indent);
            String eval = scanner.nextLine();
            evaluate_terminal(eval);





        }
    }

    protected static void evaluate_terminal (String input) {

        if (input.equals("")) {
            return;

        } else if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);

        } else if (input.startsWith("exit")) {


        } else if (input.startsWith("help")) {

        } else {
            try {
                throw new Error("Unknown command: " + input);
            } catch (Error e) { e.printStackTrace(); }
        }



    }

}

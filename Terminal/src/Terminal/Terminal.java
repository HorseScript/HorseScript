/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal;

import Terminal.Modules.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;


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

        } else if (input.startsWith("exit")) {
            exit._startsWith(input);



        } else if (input.replace(" ", "").equals("eval")) {
            eval._help(input);




        } else if (input.startsWith("eval ")) {
            eval.evaluator(input);


        } else if (input.replace(" ", "").equals("console")) {
            console._help(input);




        } else if (input.startsWith("console ")) {
            console._startsWith(input);


        } else if (input.startsWith("help")) {
            help._startsWith(input);



        } else if (input.replace(" ", "").equals("horse")) {
            horse._help(input);



        } else if (input.startsWith("horse ")) {
            horse._startsWith(input);


        } else if (input.replace(" ", "").equals("dir")) {
            dir._help(input);


        } else if (input.startsWith("dir ")) {
            dir._changeDir(input);


        } else if (input.replace(" ", "").equals("hsx")) {
            hsx._help(input);


        } else if (input.startsWith("hsx ")) {
            hsx._startsWith(input);




        } else {
            try {
                throw new Error("Unknown command: " + input);
            } catch (Error e) { e.printStackTrace(); Thread.sleep(100); }
        }



    }


}

/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter;import java.util.Scanner;

import c.c;

public class Console {

    private static volatile boolean running = false;


    public static void main(String[] args) throws Exception {

        System.out.println(c.yellow + "HorseScript Console" + c.white);


        while (true) {

            new Thread(() -> {

                running = true;
                Scanner scanner = new Scanner(System.in);
                String nextInput = "";
                while (true) {

                    System.out.print(ROM.console_indent);
                    nextInput = scanner.nextLine();
                    try { Interpreter.interpret(nextInput); } catch (Exception ignored) {}
                }

            }).start();


            running = false;


            do {
                Thread.sleep(1000);
            } while (running);

        }

    }

}

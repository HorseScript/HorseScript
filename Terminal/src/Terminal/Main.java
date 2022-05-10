/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal;public class Main {

    public static void main (String[] args) throws Exception {

        if (System.getProperty("os.name").contains("Windows")) {
            ROM.directory = System.getenv("HOMEPATH");
            ROM.homeDir = System.getenv("HOMEPATH");


        } else if (System.getProperty("os.name").contains("Mac")) {
            ROM.directory = System.getenv("HOME");
            ROM.homeDir = System.getenv("HOME");

        } else if (System.getProperty("os.name").contains("Linux")) {
            ROM.directory = System.getenv("HOME");
            ROM.homeDir = System.getenv("HOME");


        } else {
            System.out.println("Unsupported OS.");
            return;
        }

        Terminal.main(args);
    }

}

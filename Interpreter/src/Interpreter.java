/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

import horse.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {


    public static void main(String[] args) {
        System.out.println("To run the HorseScript Interpreter, run the \"Main\" class.");
    }

    public static void interpret (String code) throws Exception {




        String[] lines2 = code.split("\\n");
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(lines2));


        for (String line : lines) {

            line = line.replace("\n", "");

            String output;

            if (line.equals("")) {
                continue;
            }

            if (line.toLowerCase().startsWith("exit")) {
                exit._main(line);


            } else if (line.toLowerCase().startsWith("horse ") || line.equalsIgnoreCase("horse")) {
                horse._startsWith(line);


            } else if (line.toLowerCase().startsWith("debug ") || line.equalsIgnoreCase("debug")) {
                debug._startsWith(line);


            } else if (line.toLowerCase().startsWith("var ") || line.equalsIgnoreCase("var")) {
                variable._startsWith(line);


            } else if (line.toLowerCase().startsWith("ram ") || line.equalsIgnoreCase("ram")) {
                ram._startsWith(line);

            } else {
                throw new ParseException("Unknown command: " + line, 0);
            }

        }

    }

}

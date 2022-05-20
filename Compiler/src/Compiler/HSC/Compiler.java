/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Compiler.HSC;

import Color.c;
import Compiler.config.Options;
import Compiler.x;
import Interpreter.Interpreter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;


public class Compiler {

    private static Options options;


    public static void Compile (@NotNull Options options) throws Exception {


        Compiler.options = options;

        switch (options.task) {
            case minify -> minify(true);
            case beautify -> beautify();
            case optimize -> optimize();
            case fix -> fix();
            case check -> check();
        }

    }


    private static String minify (Boolean emit) throws Exception {

        StringBuilder WorkingFile = new StringBuilder();

        for (File file : Objects.requireNonNull(options.srcDir.listFiles())) {

            if (file.isFile()) {

                x.log(c.green + "File " + file.getName() + " is a file.");

                if (file.getName().endsWith(".hscript")) {


                    if (!file.getName().equals("index.hscript")) {

                        Scanner sc = new Scanner(file);

                        // we just need to use \\Z as delimiter
                        sc.useDelimiter("\\Z");

                        // set toRead to the content of the file
                        String toRead = sc.next();


                        WorkingFile.append(toRead);


                    } else {
                        x.log(c.blue + "Index will be compiled last.");
                    }


                } else {
                    x.log(c.yellow + "File " + file.getName() + " is not a .hscript file.");
                }


            } else {
                x.log(c.yellow + file.getName() + " is not a file.");
            }


        }


        Scanner sc = new Scanner(new File(options.srcDir + "/index.hscript"));

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");

        // set toRead to the content of the file
        String toRead = sc.next();


        WorkingFile.append(toRead);








        // TIME TO MINIFY

        StringBuilder FinalFile = new StringBuilder();

        for (String line : WorkingFile.toString().split("\\n")) {

            if (line.equals("")) {
                continue;
            }


            // Remove empty lines
            final String s = line.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "");


            if (s.replaceAll("\\n", "").equals("")) {
                continue;
            }

            // Remove comments
            if (s.replaceAll("\\n", "").startsWith("~")) {
                continue;
            }

            FinalFile.append(line.replaceAll("\t", "").replaceAll("\n", "").replaceAll("\\n", ""));


        }


        FinalFile = new StringBuilder(FinalFile.toString().replaceAll("\n", ""));


        if (emit) {

            File outputFile = new File(options.outDir + "/index.hscript");


            if (outputFile.delete()) {
                x.log(c.green + "File " + outputFile.getName() + " was deleted.");
            } else {
                x.log(c.yellow + "File " + outputFile.getName() + " was not deleted.");
            }


            if (outputFile.createNewFile()) {
                x.log(c.green + "File " + outputFile.getName() + " was created.");
            } else {
                x.log(c.red + "File " + outputFile.getName() + " was not created.");
            }


            FileWriter fw = new FileWriter(outputFile);
            fw.write(FinalFile.toString());
            fw.close();

            x.log(c.green + "File " + outputFile.getName() + " was written.");
        }

        return FinalFile.toString();

    }


    private static void beautify () throws Exception {




    }

    private static void optimize () throws Exception {


    }


    private static void fix () throws Exception {


    }


    private static void check () throws Exception {

        if (!options.runTests) {

            x.log("\n\n");
            x.log(c.gray + "[HS-C] " + c.purple + "*CHECK* " + c.green + "test is false in HorseScript.json, therefore there are no tests to run.\n");
            x.log(c.yellow + "No tests to run.\n");

        } else {

            String toTest = minify(false);

            x.log(c.yellow + "Running tests...");
            x.log(c.white + "\n{\n");
            Boolean NoErrors = Interpreter.interpret(toTest);
            x.log(c.white + "\n}\n");

            if (NoErrors) {

                x.log("\n\n");
                x.log(c.gray + "[HS-C] " + c.purple + "*CHECK* " + c.green + "No errors encountered.\n");
                x.log(c.green + "Tests passed.\n");

            } else {

                x.log("\n\n");
                x.log(c.gray + "[HS-C] " + c.purple + "*CHECK* " + c.red + "Errors encountered.\n");
                x.log(c.red + "Tests failed.\n");

            }

        }





    }



}

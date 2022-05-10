/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package hs_c.HSC;

import hs_c.config.Options;
import hs_c.x;
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
            case minify -> minify();
            case beautify -> beautify();
            case optimize -> optimize();
            case fix -> fix();
            case check -> check();
        }

    }


    private static void minify () throws Exception {

        StringBuilder WorkingFile = new StringBuilder();

        for (File file : Objects.requireNonNull(options.srcDir.listFiles())) {

            if (file.isFile()) {

                x.log("File " + file.getName() + " is a file.");

                if (file.getName().endsWith(".hscript")) {


                    if (!file.getName().equals("index.hscript")) {

                        Scanner sc = new Scanner(file);

                        // we just need to use \\Z as delimiter
                        sc.useDelimiter("\\Z");

                        // set toRead to the content of the file
                        String toRead = sc.next();


                        WorkingFile.append(toRead);


                    } else {
                        x.log("Index will be compiled last.");
                    }


                } else {
                    x.log("File " + file.getName() + " is not a .hscript file.");
                }


            } else {
                x.log("File " + file.getName() + " is not a file.");
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




        File outputFile = new File(options.outDir + "/index.hscript");


        if (outputFile.delete()) {
            x.log("File " + outputFile.getName() + " was deleted.");
        } else {
            x.log("File " + outputFile.getName() + " was not deleted.");
        }


        if (outputFile.createNewFile()) {
            x.log("File " + outputFile.getName() + " was created.");
        } else {
            x.log("File " + outputFile.getName() + " was not created.");
        }


        FileWriter fw = new FileWriter(outputFile);
        fw.write(FinalFile.toString());
        fw.close();

        x.log("File " + outputFile.getName() + " was written.");




    }


    private static void beautify () throws Exception {




    }

    private static void optimize () throws Exception {


    }


    private static void fix () throws Exception {


    }


    private static void check () throws Exception {

        if (!options.runTests) {

            x.log("No tests to run.");
            return;

        }





    }



}

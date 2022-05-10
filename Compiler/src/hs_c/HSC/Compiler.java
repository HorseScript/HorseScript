/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package hs_c.HSC;

import hs_c.config.Options;
import hs_c.x;
import org.jetbrains.annotations.NotNull;

import java.io.File;
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

        String WorkingFile = "";

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


                        WorkingFile += "\n" + toRead;


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


        WorkingFile += "\n" + toRead;


        String FinalFile = "";


        // TIME TO MINIFY

        for (String line : WorkingFile.split("\\n")) {


            // Remove empty lines
            if (line.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "").replaceAll("\\n", "").equals("")) {
                line = "";
            }

            // Remove comments
            if (line.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "").replaceAll("\\n", "").startsWith("~")) {
                line = "";
            }

            FinalFile += line;


        }


        System.out.println(FinalFile);




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




    }


    private static void beautify () {




    }

    private static void optimize () {


    }


    private static void fix () {


    }


    private static void check () {

        if (!options.runTests) {

            x.log("No tests to run.");
            return;

        }





    }



}

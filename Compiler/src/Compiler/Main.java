/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler;


import Color.c;
import Compiler.HSC.Compiler;
import Compiler.config.Options;
import Compiler.configfile.HorseScript;
import Compiler.configfile.ParseConfig;


public class Main {

    public static void main (String[] args) throws Exception {


        // Print some important stuff
        intro();


        // Take the HorseScript.json into a configuration object
        HorseScript toConvert = ParseConfig.takeJson();

        // Convert the configuration file into a program-readable and simplified configuration object
        Options OPTIONS = x.convert(toConvert);

        // Print the options, might help with debug
        x.log(c.blue + OPTIONS);

        // Then we compile!
        Compiler.Compile(OPTIONS);


    }

    /** Utility class <b>Main</b> cannot be initialized. */
    private Main () {}

    private static void intro () {

        x.log(c.purple + "\n------- HorseScript Compiler v0.0.1 -------\n");
        x.log(c.green + "☑ Featured in HorseScriptX");



    }




}

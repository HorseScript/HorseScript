/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler;


import Compiler.HSC.Compiler;
import Compiler.config.Options;
import Compiler.configfile.HorseScript;
import Compiler.configfile.ParseConfig;

public class Main {

    public static void main (String[] args) throws Exception {

        HorseScript toConvert = ParseConfig.takeJson();

        Options OPTIONS = x.convert(toConvert);

        System.out.println(OPTIONS);

        // then we compile!

        Compiler.Compile(OPTIONS);


    }

    /** Utility class <b>Main</b> cannot be initialized. */
    private Main () {}




}

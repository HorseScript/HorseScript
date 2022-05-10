/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package hs_c;


import hs_c.HSC.Compiler;
import hs_c.config.Options;
import hs_c.configfile.HorseScript;
import hs_c.configfile.ParseConfig;

public class Main {

    public static void main (String[] args) throws Exception {

        HorseScript toConvert = ParseConfig.takeJson();

        Options OPTIONS = x.convert(toConvert);

        System.out.println(OPTIONS);

        // then we compile!

        Compiler.Compile(OPTIONS);


    }




}

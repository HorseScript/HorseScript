/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler.configfile;

import org.jetbrains.annotations.NotNull;

public enum type {

    minify,
    beautify,
    optimize,
    fix,
    check,

    error;


    

    public static @NotNull type getType (String s) {
        if (s.equalsIgnoreCase("minify")) {
            return minify;
        } else if (s.equalsIgnoreCase("beautify")) {
            return beautify;
        } else if (s.equalsIgnoreCase("optimize")) {
            return optimize;
        } else if (s.equalsIgnoreCase("fix")) {
            return fix;
        } else if (s.equalsIgnoreCase("check")) {
            return check;
        } else {
            return error;
        }
    }


}

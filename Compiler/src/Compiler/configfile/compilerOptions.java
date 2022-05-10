/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler.configfile;

import org.jetbrains.annotations.NotNull;


/** HorseScript Compiler options */
public class compilerOptions {


    /** Compiler job */
    public final @NotNull String type;

    /** Output directory */
    public final @NotNull String out;

    /** Run tests */
    public final @NotNull Boolean test;

    /** Remove comments */
    public final @NotNull Boolean removeComments;

    /** Remove empty lines */
    public final @NotNull Boolean removeLines;



    /** HorseScript Compiler options */
    public compilerOptions (@NotNull String type, @NotNull String out, @NotNull Boolean test, @NotNull Boolean removeComments, @NotNull Boolean removeLines) {

        this.type = type;
        this.out = out;
        this.test = test;
        this.removeComments = removeComments;
        this.removeLines = removeLines;
    }

}

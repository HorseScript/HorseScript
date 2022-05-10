/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler.configfile;

import org.jetbrains.annotations.NotNull;


/** HorseScript project configuration */
public class HorseScript {

    /** Source directory to pull files from */
    public final @NotNull String src;

    /** Excluded files from the build */
    public final @NotNull String[] exclude;

    /** HorseScript Compiler options */
    public final @NotNull compilerOptions options;




    /** HorseScript project configuration */
    public HorseScript(@NotNull String src, @NotNull String[] exclude, @NotNull compilerOptions options) {

        this.src = src;
        this.exclude = exclude;
        this.options = options;
    }



}

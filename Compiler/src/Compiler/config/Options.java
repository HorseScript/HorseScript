/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package Compiler.config;

import com.google.gson.JsonObject;
import Compiler.configfile.type;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.Arrays;


/** Settings that HS-C will use to compile the HorseScript code */
public class Options {

    /** Source directory to pull files from */
    public final @NotNull File srcDir;



    /** Excluded files from the build */
    public final @NotNull File[] excludedFiles;



    /** Compiler job */
    public final @NotNull type task;

    /** output directory */
    public final @NotNull File outDir;

    /** run tests */
    public final @NotNull Boolean runTests;

    /** remove comments */
    public final @NotNull Boolean noComments;

    /** remove empty lines */
    public final @NotNull Boolean noEmptyLines;




    /** Settings that HS-C will use to compile the HorseScript code */
    public Options (@NotNull File srcDir,
                    @NotNull File[] excludedFiles,
                    @NotNull type task,
                    @NotNull File outDir,
                    @NotNull Boolean runTests,
                    @NotNull Boolean noComments,
                    @NotNull Boolean noEmptyLines)
    {

        this.srcDir = srcDir;
        this.excludedFiles = excludedFiles;
        this.task = task;
        this.outDir = outDir;
        this.runTests = runTests;
        this.noComments = noComments;
        this.noEmptyLines = noEmptyLines;
    }

    @Override public @NotNull String toString () {

        JsonObject json = new JsonObject();
        json.addProperty("srcDir", srcDir.getAbsolutePath());
        json.addProperty("excludedFiles", Arrays.toString(excludedFiles));
        json.addProperty("task", task.toString());
        json.addProperty("outDir", outDir.getAbsolutePath());
        json.addProperty("runTests", runTests);
        json.addProperty("noComments", noComments);
        json.addProperty("noEmptyLines", noEmptyLines);




        return json.toString();
    }


}

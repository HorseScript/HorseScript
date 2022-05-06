/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package hs_c;

import hs_c.config.Options;
import hs_c.configfile.HorseScript;
import hs_c.configfile.compilerOptions;
import hs_c.configfile.type;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public final @NotNull class x {


    @SuppressWarnings("all")
    public static final void log (@NotNull String s) {
        System.out.println(s);
    }


    /** <p>Convert the HorseScript config object to an Options object.</p>
     *
     * <br><br>
     * @return An Options object.
     * @since 0.0.1
     * @author HorseScript
     * */
    @SuppressWarnings("all")
    public static final @NotNull Options convert (@NotNull HorseScript hs) {

        compilerOptions opt = hs.options;


        // begin srcDir
        File srcDir;

        if (hs.src.startsWith(".")) {

            srcDir = new File(System.getProperty("user.dir") + hs.src.replaceFirst("\\.", ""));

        } else {

            srcDir = new File(System.getProperty("user.dir") + hs.src);
        }
        // end srcDir


        // begin excludedFiles
        File[] excludedFiles;


        if ((hs.exclude == null) || (hs.exclude[0].equals(""))) {

            excludedFiles = new File[1];
            excludedFiles[0] = new File("");

        } else {

            ArrayList<File> excludedFilesTemp = new ArrayList<>();


            for (String f : hs.exclude) {


                File file = new File(srcDir, f);

                if (file.isDirectory()) {

                    File[] files = file.listFiles();


                    assert files != null;
                    excludedFilesTemp.addAll(Arrays.stream(files).toList());

                }


            }


            excludedFiles = excludedFilesTemp.toArray(new File[0]);


        }
        // end excludedFiles



        // begin task
        type task;
        try {
            task = type.getType(opt.type.toLowerCase());
        } catch (Exception e) {
            task = type.error;
            log("Error: " + e.getMessage());
            throw e;
        }
        // end task



        // begin outDir
        File outDir = new File(System.getProperty("user.dir") + opt.out);

        if (!outDir.isDirectory()) {
            throw new IllegalStateException("outDir is not a directory");
        }

        if (!outDir.exists()) {

            Boolean success;


            try {
                success = outDir.mkdirs();
            } catch (Exception e) {
                throw e;
            }


            if (success) {
                log("outDir created");
            } else {
                log("outDir not created");
            }
        } else {
            log("outDir exists");
        }
        // end outDir



        // begin runTests
        Boolean runTests = opt.test;
        // end runTests


        // begin noComments
        Boolean noComments = opt.removeComments;
        // end noComments


        // begin noEmptyLines
        Boolean noEmptyLines = opt.removeLines;
        // end noEmptyLines


        @SuppressWarnings("redundant")
        Options output = new Options(srcDir, excludedFiles, task, outDir, runTests, noComments, noEmptyLines);



        return output;
    }


}

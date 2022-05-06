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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public final @NotNull class x {


    @SuppressWarnings("all")
    public static final void log (@NotNull String s) {
        System.out.println(s);
    }


    // @SuppressWarnings("all")
    public static final @NotNull Options convert (HorseScript hs, compilerOptions opt) {


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
        try {
            type task = type.getType(opt.type);
        } catch (Exception e) {
            type task = type.error;
            log("Error: " + e.getMessage());
        }
        // end task










        Options output = null;



        return output;
    }


}

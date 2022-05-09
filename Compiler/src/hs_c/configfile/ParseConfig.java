/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package hs_c.configfile;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;



public class ParseConfig {


    public static HorseScript takeJson () throws Exception {

        // filepath
        File file = new File("./HorseScript.json");

        // scanner
        Scanner sc = new Scanner(file);

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");

        // set toRead to the content of the file
        String toRead = sc.next();

        // Reader
        JsonReader reader = new JsonReader(new StringReader(toRead));




        reader.setLenient(true); // the ignore thing



        reader.beginObject(); // {






        // --- src ---

        // "#######" = "./src/"
        if (!reader.nextName().equals("src")) throw new ParseException("src not found", 0);

        String src = reader.nextString(); // "src" = "########"



        // --- src ---








        // --- exclude ---

        if (!reader.nextName().equals("exclude")) throw new ParseException("exclude not found", 0);

        reader.beginArray(); // [


        ArrayList<String> exclude = new ArrayList<>();


        while (reader.hasNext()) {

            exclude.add(reader.nextString());


        }


        reader.endArray(); // ]

        String[] excludeArray = new String[exclude.size()];
        excludeArray = exclude.toArray(excludeArray);

        // --- exclude ---







        // --- begin CompilerOptions ---

        if (!reader.nextName().equals("compilerOptions")) throw new ParseException("compilerOptions not found", 0);

        reader.beginObject(); // {

        // --- begin CompilerOptions ---





        // --- type ---
        if (!reader.nextName().equals("type")) throw new ParseException("type not found", 0);
        String type = reader.nextString(); // "type" = "#####"
        // --- type ---





        // --- out ---
        if (!reader.nextName().equals("out")) throw new ParseException("out not found", 0);
        String out = reader.nextString(); // "out" = "#######"
        // --- out ---



        // --- test ---
        if (!reader.nextName().equals("test")) throw new ParseException("test not found", 0);
        boolean test = reader.nextBoolean(); // "test" = ####
        // --- test ---



        // --- removeComments ---
        if (!reader.nextName().equals("removeComments")) throw new ParseException("removeComments not found", 0);
        boolean removeComments = reader.nextBoolean(); // "removeComments" = ####
        // --- removeComments ---



        // --- removeLines ---
        if (!reader.nextName().equals("removeLines")) throw new ParseException("removeLines not found", 0);
        boolean removeLines = reader.nextBoolean(); // "removeLines" = ####
        // --- removeLines ---


        try {

            reader.endObject(); // }
            reader.endObject(); // }

        } catch (Exception e) {

        }



        compilerOptions compilerOptions = new compilerOptions(type, out, test, removeComments, removeLines);

        HorseScript horseScript = new HorseScript(src, excludeArray, compilerOptions);


        return horseScript;
    }

}

/*
 * Copyright (c) 2022, HorseScript
 *  All rights reserved.
 */

package hs_c.configfile;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;



public class ParseConfig {


    public static JsonObject takeJson () throws Exception {

        // filepath
        File file = new File("./HorseScript.json");

        // scanner
        Scanner sc = new Scanner(file);

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");

        // set toRead to the content of the file
        String toRead = sc.next();


        JsonReader reader = new JsonReader(new StringReader(toRead));

        reader.beginArray();




        JsonObject e = new JsonObject();



        return null;
    }

}

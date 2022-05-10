/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter.horse

import Interpreter.RAM
import Color.c;

object debug {

    const val version : String = "0.0.1"



    @JvmStatic fun _startsWith (line: String) {

        var line2 : String = line.replaceFirst("debug ", "")

        if (line2.startsWith("enabled")) {
            debug.enabled(line.replaceFirst("debug ", ""))
        } else if (line.equals("debug")) {
            println("HorseScript debug tools version $version")
        } else if (line2.startsWith("help")) {
            println("HorseScript debug tools help\nCommands:\ndebug enabled <boolean>")
        } else {

            try {
                throw ClassNotFoundException("HorseScript debug tools: command not found")
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }

    @JvmStatic fun enabled (line: String) {

        if (line == "enabled" || line == "enabled ") {
            throw IllegalArgumentException(c.yellow + "Enabled requires a Boolean. Usage: " + c.cyan + "debug enabled true" + c.white)
        }


        val line_1 : String = line.replaceFirst("enabled ", "")



        RAM.debug = line_1.toBoolean()


        println("Debug is now " + RAM.debug);

    }



}
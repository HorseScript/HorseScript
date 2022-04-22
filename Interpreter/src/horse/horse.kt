/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package horse

object horse {
// Development: In development, though `horse print` works.

    const val version : String = "0.0.1"



    @JvmStatic fun _startsWith (line: String) {

        val line2 : String = line.replaceFirst("horse ", "")

        if (line2.startsWith("print")) {
            horse.print(line.replaceFirst("horse ", ""))
        } else if (line.equals("horse")) {
            println("HorseScript Horse Library | Version: $version")
        } else if (line2.startsWith("help")) {
            println("HorseScript horse library help\nCommands:\nhorse print")
        } else {

            try {
                throw ClassNotFoundException("HorseScript horse library: command not found")
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }

    @JvmStatic fun print (line: String) {

        if (line == "print" || line == "print " || (!line.contains("\""))) {
            throw IllegalArgumentException(ROM.yellow + "Print requires a String. Usage: " + ROM.cyan + "horse print \"String\"" + ROM.white)
        }


        val line_1 : String = line.replaceFirst("print ", "")

        if (!line_1.startsWith("\"") || !line_1.endsWith("\"")) {
            throw IllegalArgumentException(ROM.yellow + "Print requires a String. Usage: " + ROM.cyan + "horse print \"String\"" + ROM.white)
        }

        val output : String = line_1.replace("\"", "");

        println(output)



    }

}
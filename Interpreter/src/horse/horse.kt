/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package horse

import resources.HorseError
import javax.swing.JFrame
import javax.swing.JLabel

object horse {
// Development: In development, though `horse print` works.

    const val version : String = "0.0.1"



    @JvmStatic fun _startsWith (line: String) {

        val line2 : String = line.replaceFirst("horse ", "")

        if (line2.startsWith("print")) {
            horse.print(line.replaceFirst("horse ", ""))
        } else if (line2.startsWith("frame")) {
            horse.frame(line.replaceFirst("horse ", ""))
        } else if (line.equals("horse")) {
            println("HorseScript Horse Library | Version: $version")
        } else if (line2.startsWith("help")) {
            println("HorseScript horse library help\nCommands:\nhorse print")
        } else {

            HorseError.badLine(line, "HorseScript horse library: command not found")
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

    @JvmStatic fun frame (line: String) {


        val f : JFrame = JFrame("HorseScript")
        f.setSize(400, 400)
        f.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE

        val e : JLabel = JLabel("HorseScript Popup")
        e.setSize(200, 200)
        f.add(e)

        f.pack()
        f.isVisible = true
    }

}
/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter.horse

import Interpreter.RAM
import Interpreter.resources.Constant
import Interpreter.resources.HorseError
import Interpreter.resources.SearchTypes
import Interpreter.resources.Variable
import javax.swing.JFrame
import javax.swing.JLabel
import Color.c;

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

        if (line == "print" || line == "print ") {
            throw IllegalArgumentException(c.yellow + "Print requires a String. Usage: " + c.cyan + "horse print \"String\"" + c.white)
        }


        val line_1 : String = line.replaceFirst("print ", "")

        if (!line_1.startsWith("\"") || !line_1.endsWith("\"")) {

            val variableToFind = RAM.getVar(line_1, SearchTypes.EQUALS_NAME);

            if (variableToFind.javaClass == Variable::class.java) {

                println((variableToFind as Variable).content)

            } else if (variableToFind.javaClass == Constant::class.java) {

                println((variableToFind as Constant).content)

            } else {


                throw IllegalArgumentException(c.yellow + "Print requires a String or variable. Usage: " + c.cyan + "horse print \"String\"" + c.white)

            }

        }

        val output : String = line_1.replace("\"", "");

        println(output)

    }

    @JvmStatic fun frame (line: String) {


        val f : JFrame = JFrame("HorseScript")
        f.setSize(400, 400)
        f.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE

        val e : JLabel = JLabel(line)
        e.setSize(400, 300)
        f.add(e)

        f.pack()
        f.isVisible = true
    }

}
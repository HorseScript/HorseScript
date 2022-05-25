/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter.horse

import Interpreter.RAM
import Interpreter.resources.Result
import Interpreter.resources.Variable
import Interpreter.resources.VariableTyping
import java.util.*

object ram {
// Development: In development

    const val version : String = "0.0.2"



    @JvmStatic fun _startsWith (line: String) {

        val line2 : String = line.replaceFirst("ram ", "")

        if (line.equals("ram")) {
            println("HorseScript RAM ConsoleUI | Version: ${variable.version}")

        } else if (line.replace(" ", "").equals("ramedit")) {
            println("HorseScript RAM UI: Edit RAM\n\nUsage:\nram edit <newType> <currentName> <newValue>\nram edit String VariableName VariableContent")

        } else if (line2.lowercase().startsWith("edit")) {
            edit(line, line2)

        } else if (line2.startsWith("help")) {
            println("")


        } else {

            try {
                throw ClassNotFoundException("HorseScript RAM ConsoleUI: command not found")
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }

    @JvmStatic fun edit (line : String, line2 : String) {

        val line3 : String = line2.replaceFirst("edit ", "");

        var linescan : Scanner = Scanner(line3)

        val varType : String = linescan.next()

        val varName : String = linescan.next()

        val varContent : String = linescan.nextLine().replaceFirst(" ", "")






        if (Objects.equals(RAM.getVar(varName), Result.NOT_FOUND)) {
            println("HorseScript RAM ConsoleUI: Not found")
        } else {


            val varTypeEnum : VariableTyping = variable.parseType(varType, varContent)

            val NewVar : Variable = Variable(varName, varContent, varTypeEnum)

            val OldVar : Variable = RAM.getVar(varName) as Variable


            // RAM.editVar(OldVar, NewVar)

            println("HorseScript RAM ConsoleUI: Edited")
        }


    }

}
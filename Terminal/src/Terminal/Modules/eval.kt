/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import java.util.*

class eval {

    companion object {


        @Throws(Exception::class)
        @JvmStatic fun evaluator (command: String) {
            val toEval: String
            var clean : String = command.replaceFirst("eval ".toRegex(), "")

            if (!clean.startsWith(": ")) {
                println("Bad syntax")
                println("Eval command: eval : <type> = <code>")
            } else {
                clean = clean.replaceFirst(": ".toRegex(), "")
            }

            val scanner : Scanner = Scanner(clean)
            val type : String = scanner.next()
            val code : String = clean.replaceFirst("$type = ".toRegex(), "")

            toEval = if (type == "hscript") {
                code.replace("\\\"".toRegex(), "\\\\\"")
            } else {
                println("$type is not a supported dialect of HorseScript.")
                println("Supported dialects: hscript")
                print("If you want to add this dialect, please see us on GitHub: ")
                println("https://github.com/HorseScript/HorseScript")
                return
            }

            Interpreter.Interpreter.interpret(toEval)
        }



        @JvmStatic fun _help (command: String) {
            println("Eval command: eval : <type> = <code>")
            println("This command will evaluate a line of <type> code.")
            println("<type> can be replaced with hscript, or any supported dialect.")
        }


    }
}
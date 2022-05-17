/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Interpreter.Console
import java.util.*

class console {

    companion object {


        @Throws(Exception::class)
        @JvmStatic fun _startsWith (command: String) {
            var toEval: String
            var clean : String = command.replaceFirst("console ".toRegex(), "")
            if (!clean.startsWith(": ")) {
                println("Bad syntax")
                println("Console command: console : <type>")
            } else {
                clean = clean.replaceFirst(": ".toRegex(), "")
            }
            val scanner : Scanner = Scanner(clean)
            val type : String = scanner.next()
            if (type == "hscript") {
                try {
                    Console.main(null)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                println("$type is not a supported console of HorseScript.")
                println("Supported consoles: hscript")
                print("If you want a new console to be added, please contact us on GitHub: ")
                println("https://github.com/HorseScript/HorseScript")
                return
            }
        }

        @JvmStatic fun _help (command : String) {
            println("Console command: console : <type>")
            println("This command will open a <type> console.")
            println("<type> can be replaced with hscript, or any supported console.")
        }


    }

}
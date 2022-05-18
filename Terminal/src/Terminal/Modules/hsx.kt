/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Compiler.x
import java.util.*

class hsx {

    companion object {


        @JvmStatic fun _help (command : String) {

            println("HorseScriptX command: hsx <type>")
            println("This command will use a <type> HorseScript compiler.")
            println("<type> can be replaced with hsc, or any supported compiler.")

        }



        @JvmStatic fun _startsWith (command : String) {

            var clean : String = command.replaceFirst("hsx ".toRegex(), "")

            if (!clean.startsWith(": ")) {
                println("Bad syntax")
                println("Compiler command: hsx : <type>")
            } else {
                clean = clean.replaceFirst(": ".toRegex(), "")
            }

            val scanner : Scanner = Scanner(clean)
            val type : String = scanner.next()
            if (type == "hsc") {
                try {
                    x.main(null)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                println("$type is not a supported compiler of HorseScript.")
                println("Supported compilers: hsc")
                print("If you want a new compiler to be added, please contact us on GitHub: ")
                println("https://github.com/HorseScript/HorseScript")
                return
            }


        }

    }
}
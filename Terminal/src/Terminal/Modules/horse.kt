/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Interpreter.Main
import Terminal.ROM
import java.io.IOException
import java.util.*

class horse {

    companion object {


        @Throws(IOException::class)
        @JvmStatic fun _startsWith (command: String) {
            val uuid : String = UUID.randomUUID().toString()
            val cmd2 : String = command.replaceFirst(" ".toRegex(), uuid)
            val cmd3 : String = cmd2.replace(" ".toRegex(), "").replace(uuid.toRegex(), " ")
            if (cmd3 == "horse dist") {
                if (!ROM.requireDir()) return


                val toSend : Array<String> = arrayOf("5", "dist/index.hscript")

                Main.main(toSend)

            }
        }



        @JvmStatic fun _help (command : String) {
            println("Horse command: horse <run>")
            println("This command will run a certain a HorseScript project.")
        }


    }

}
/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Terminal.ROM
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.StandardCopyOption
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
                Files.copy(
                    File(ROM.workingDirectory + "/Terminal/Interpreter.jar").toPath(),
                    File(ROM.directory + "/Interpreter.jar").toPath(),
                    StandardCopyOption.REPLACE_EXISTING
                )
                Runtime.getRuntime().exec("java -jar Interpreter.jar 5 dist/index.hscript", null, File(ROM.directory))
            }
        }



        @JvmStatic fun _help (command : String) {
            println("Horse command: horse <run>")
            println("This command will run a certain a HorseScript project.")
        }


    }

}
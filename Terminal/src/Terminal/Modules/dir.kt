/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Terminal.ROM

class dir {

    companion object {


        @JvmStatic fun _changeDir (command : String) {
            ROM.directory = command.replace("dir ", "")
            ROM.terminal_indent = ROM.blue + ROM.directory + ROM.cyan + " > " + ROM.white
        }

        @JvmStatic fun _help (command : String) {
            println("Dir command: dir <directory>")
            println("This command will change the directory.")
        }


    }

}
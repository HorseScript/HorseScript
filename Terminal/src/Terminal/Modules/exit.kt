/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import kotlin.system.exitProcess

class exit {

    companion object {


        @JvmStatic fun _startsWith (command : String) {
            println("Exiting...")
            exitProcess(0)
        }


    }

}
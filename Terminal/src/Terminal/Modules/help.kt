/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Terminal.Modules

import Terminal.ROM

class help {

    companion object {


        @JvmStatic fun _startsWith (command : String) {
            println(ROM.purple + "HorseScript Terminal | Version " + ROM.TERMINAL_VERSION + ROM.white)
            println("Commands:\nexit\neval <code>\nhorse <command>")
        }


    }

}
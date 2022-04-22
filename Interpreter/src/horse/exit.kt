/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package horse

import kotlin.system.exitProcess

/** The exit module, definitely the simplest module in HorseScript.
 *
 * @author gemsvidø
 * @since HorseScript 0.0.1
 *
 * */
object exit {
// Development: Complete and stable.

    const val version : String = "0.0.1"




    @JvmStatic fun _main (line: String) {

        val line_1 : String = line.replace(" ", "")

        if (line_1 == "exit") {
            exitProcess(0)
        } else {

            if (line.contains("exit \$info")) {
                println("HorseScript Exit library | Version $version")
            }

            val exitCode : Int = (line.replace("exit ", "")).toInt()
            exitProcess(exitCode)


        }
    }





}
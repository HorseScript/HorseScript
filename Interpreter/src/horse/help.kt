/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package horse

object help {

    @JvmStatic fun _main (line : String) {
        println("""
            
            HorseScript
            
            
            Commands:
            
            
            help
                Prints this help message.
                
                
            exit
                Exits the program.
                
                exit <code>
                exit """ + "\$info" + """"
                
                
                
            horse
               HorseScript Horse Library.   
                
               horse print "<text>"
               horse frame
               
               
               
            ram
               HorseScript Ram ConsoleUI.
               
               ram edit <newType> <currentName> <newValue>
               ram help
               
               
               
            var
               HorseScript Variable Library.
               
               var new <type> <name> <value>
               var getAll
               var help
               
               
            debug
               HorseScript Debugger.
               
               debug help
               
            
        """
        )
    }



}
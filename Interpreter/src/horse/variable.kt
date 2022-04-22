package horse

import resources.Variable
import resources.VariableTyping


object variable {
// Development: In development, but we have some version of it running.

    const val version : String = "0.0.2"


    @JvmStatic fun _startsWith (line: String) {

        val line2 : String = line.replaceFirst("var ", "")

        if (line.equals("var")) {
            println("HorseScript Variable Library | Version: $version")

        } else if (line.replace(" ", "").equals("varnew")) {
            println("HorseScript Variable Library: New Variable\n\nUsage:\nvar new <type> <name> <value>\nvar new String VariableName VariableContent")

        } else if (line2.lowercase().startsWith("new")) {
            create(line.replaceFirst("var new ", ""))

        } else if (line2.startsWith("help")) {
            println("HorseScript variable library help\nCommands:\nvar new\nvar getAll")

        } else if (line2.startsWith("getAll")) {
            getAll(line)


        } else {

            try {
                throw ClassNotFoundException("HorseScript variable library: command not found")
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }

    @JvmStatic fun create (line : String) {

        val uuid1 : String = java.util.UUID.randomUUID().toString()

        val uuid2 : String = java.util.UUID.randomUUID().toString()

        val line1 : String = line.replaceFirst(" ", uuid1);

        val line2 : String = line1.replaceFirst(" ", uuid2);

        val parts : List<String> = line1.split(uuid1)

        val parts2 : List<String> = line2.split(uuid2)

        val out : Any

        val typ : VariableTyping


        when (parts[0].lowercase()) {
            "int", "integer" -> {
                val int : Int = parts[1].toInt()
                out = int
                typ = VariableTyping.INTEGER
                println("Variable Type: Integer")
            }
            "double" -> {
                val double : Double = parts[1].toDouble()
                out = double
                typ = VariableTyping.DOUBLE
                println("Variable Type: Double")
            }
            "string", "str" -> {
                val string : String = parts[1]
                out = string
                typ = VariableTyping.STRING
                println("Variable Type: String")
            }
            "boolean", "bool" -> {
                val boolean : Boolean = parts[1].toBoolean()
                out = boolean
                typ = VariableTyping.BOOLEAN
                println("Variable Type: Boolean")
            }
            "character", "char" -> {
                val char : Char = parts[1].toString().get(0);
                out = char
                typ = VariableTyping.CHARACTER
                println("Variable Type: Character")
            }
            else -> {
                val any : Any = parts[1]
                out = any
                typ = VariableTyping.ANY
                println("Variable Type: Any")
            }
        }

        val varname : String = parts[1].split(" ")[0]

        val var1 : Variable = Variable(varname, parts2[1], typ)
        println(ROM.green + "Package: " + ROM.cyan + var1.toString())

        RAM.addVar(var1)


        println(ROM.green + "Created variable " + ROM.cyan + var1.name + ROM.green + " with value " + ROM.cyan + var1.content)

    }

    @JvmStatic fun getAll (line : String) {
        val all : String = RAM.getAll()
        println(all)
    }

    @JvmStatic fun parseType (text : String, Content : String) : VariableTyping {


        val out : Any

        val typ : VariableTyping


        when (text.lowercase()) {
            "int", "integer" -> {
                val int : Int = Content.toInt()
                out = int
                typ = VariableTyping.INTEGER
                println("Variable Type: Integer")
            }
            "double" -> {
                val double : Double = Content.toDouble()
                out = double
                typ = VariableTyping.DOUBLE
                println("Variable Type: Double")
            }
            "string", "str" -> {
                val string : String = Content
                out = string
                typ = VariableTyping.STRING
                println("Variable Type: String")
            }
            "boolean", "bool" -> {
                val boolean : Boolean = Content.toBoolean()
                out = boolean
                typ = VariableTyping.BOOLEAN
                println("Variable Type: Boolean")
            }
            "character", "char" -> {
                val char : Char = Content.toString().get(0);
                out = char
                typ = VariableTyping.CHARACTER
                println("Variable Type: Character")
            }
            else -> {
                val any : Any = Content
                out = any
                typ = VariableTyping.ANY
                println("Variable Type: Any")
            }
        }



        return typ
    }











}
# HorseScript
A simple, fast, and powerful programming language, written completely and powered by Java 17.

<br>


### Line separation in HorseScript
The line separation is `;;`.

Example:
```horsescript
horse print "horsescript is goated";;
~ A comment ;;
horse frame;;
horse exit;;
```
<br>


### Print line to console in HorseScript
You'll use `horse print "<text>"`.

Example:
```horsescript
horse print "horsescript is goated";;
```
<br>

### GUI frame in HorseScript
You'll use `horse frame`.

Example:
```horsescript
horse frame;;
```
<br>


### Single line Comments in HorseScript
Single line comments start with a `~`.

Example:
```horsescript
~ This is a comment
~This is also a comment ;;
```
<br>


### Multi line Comments in HorseScript
**COMING SOON. THIS IS NOT IMPLEMENTED YET.**

Multi line comments start with `~*`, and end with `*~`.

Example:
```horsescript
~* Start multi line comment
   This is Still comment text
End multi line comment *~ ;;
```
<br>


### HorseScript Interpreter from Command Line
Use the command line to run a HorseScript line. You'll have to escape characters though.


Example:
```shell
java -jar Interpreter.jar 6 horse print \"String\"
```
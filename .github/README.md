# HorseScript
A simple, fast, and powerful programming language, just kidding it sucks.


### What is HorseScript written on?
- [HSC] **HS-C**, aka the HorseScript-Compiler is written completely in **Java** 17.
- [HSC] **HS-C** also uses gson to handle JSON.
- [HSI] The HorseScript **Interpreter** is written in **Java** 17.
- [HSI] Horse modules for the **Interpreter** are written in **Kotlin**.
- [HSK] The HorseScript **Color Codes** are written completely in **Java** 17.
- [HST] The HorseScript **Terminal** is written in **Java** 17.
- [HST] Modules (specific commands) for the **Terminal** are written in **Kotlin**.


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
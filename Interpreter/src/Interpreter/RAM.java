/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter;

import Interpreter.resources.Constant;
import Interpreter.resources.HorseError;
import Interpreter.resources.Variable;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;


public class RAM {

    /**
     <b>useROM</b><br><br>

     0 = Do not use ROM. Scanner input instead. <br>
     1 = Use ROM String.<br>
     2 = Use ROM File.<br>
     3 = Do not use ROM. Use the HorseScript console instead. <br>

     */
    public static Byte useROM = -1;

    public static volatile @NotNull Boolean debug = false;

    public static File toInterpret;

    public static String txtInterpret;


    // BEGIN VARIABLE HANDLING

    private static final HashMap<String, Object> variables = new HashMap<>();

    public static @NotNull Boolean addVar (@NotNull Object VariableOrConst) {


        String varName;
        Class<? extends @NotNull Object> varType = VariableOrConst.getClass();


        if (varType == Variable.class) {

            varName = ((Variable) VariableOrConst).name;
        }
        else if (varType == Constant.class) {

            varName = ((Constant) VariableOrConst).name;
        }
        else {
            HorseError.badLine("", "Only variables and constants can be added to the RAM.");
            return false;
        }


        if (getDefenition(varName)) {
            HorseError.badLine("", "Variable " + varName + " is already defined.");
            return false;

        } else {




        if (varType == Variable.class) {

            if (((Variable) VariableOrConst).validate()) {
                variables.put(varName, VariableOrConst);
                return true;
            } else {
                HorseError.badLine("", "Variable " + varName + " is not valid.");
                return false;
            }

        } else {

                if (((Constant) VariableOrConst).validate()) {
                    variables.put(varName, VariableOrConst);
                    return true;
                } else {
                    HorseError.badLine("", "Constant " + varName + " is not valid.");
                    return false;
                }

            }
        }


    }

    public static @NotNull String getAll () {

        // Collection<Object> objects = variables.values();
        // String output = Arrays.toString(objects.toArray());

        return Arrays.toString(variables.values().toArray());
    }

    public static @NotNull Boolean getDefenition (@NotNull String match) {

        /*
        Object output = variables.get(match);

        if (output == null) {
            return false;
        } else {
            return true;
        }
        */

        return variables.get(match) != null;
    }

    public static Object getVar (@NotNull String match) {

        return variables.get(match);

    }


    // END VARIABLE HANDLING

}

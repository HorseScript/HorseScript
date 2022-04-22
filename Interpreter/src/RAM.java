/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

import org.jetbrains.annotations.NotNull;
import resources.Constant;
import resources.Result;
import resources.SearchTypes;
import resources.Variable;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


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

    public static volatile ArrayList<Object> variables = new ArrayList<>();

    public static @NotNull Boolean addVar (Object VariableOrConst) {

        if (VariableOrConst.getClass() == Variable.class) {

            if (((Variable) VariableOrConst).validate()) {
                variables.add(VariableOrConst);
                return true;
            } else {
                System.out.println("Variable " + ((Variable) VariableOrConst).name + " is invalid.");
                return Boolean.FALSE;
            }



        } else if (VariableOrConst.getClass() == Constant.class) {

            variables.add(VariableOrConst);
            return true;

        } else {
            System.out.println(VariableOrConst.getClass() + " variables cannot be added to the variables RAM.");
            return Boolean.FALSE;
        }
    }

    public static void editVar (Variable varToEdit, Variable newVar) {

        if (varToEdit.name.equals(newVar.name)) {


            int index = variables.indexOf(varToEdit);

            variables.set(index, newVar);
        } else {
            System.out.println("The variable names do not match.");
        }

    }

    public static @NotNull String getAll () {
        return Arrays.toString(variables.toArray());
    }



    public static @NotNull Object getVar (String match, SearchTypes type) {




        switch (type) {

            case CONTAINS_ANY: if (CONTAINS_ANY(match) != Boolean.FALSE) return CONTAINS_ANY(match);

            case CONTAINS_NAME: if (CONTAINS_NAME(match) != Boolean.FALSE) return CONTAINS_NAME(match);

            case CONTAINS_CONTENT: if (CONTAINS_CONTENT(match) != Boolean.FALSE) return CONTAINS_CONTENT(match);

            case EQUALS_ANY: if (EQUALS_NAME(match) != Boolean.FALSE) return EQUALS_ANY(match);

            case EQUALS_NAME: if (EQUALS_NAME(match) != Boolean.FALSE) return EQUALS_NAME(match);

            case EQUALS_CONTENT: if (EQUALS_CONTENT(match) != Boolean.FALSE) return EQUALS_CONTENT(match);

            default: throw new IllegalStateException("You need a valid search type.");
        }


    }

    private static @NotNull Object CONTAINS_ANY (String match) {

        Object output = new Object();

        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.name.contains(match) || c.content.toString().contains(match)) {
                    return c;
                } else {
                    continue;
                }


            } else if (!_constant) {

                if (v.name.contains(match) || v.content.toString().contains(match)) {
                    return v;
                } else {
                    continue;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;


    }

    private static @NotNull Object CONTAINS_NAME (String match) {

        Object output = new Object();

        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.name.contains(match)) {
                    return c;
                } else {
                    continue;
                }


            } else if (!_constant) {

                if (v.name.contains(match)) {
                    return v;
                } else {
                    continue;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;


    }

    private static @NotNull Object CONTAINS_CONTENT (String match) {

        Object output = new Object();

        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.content.toString().contains(match)) {
                    return c;
                } else {
                    continue;
                }


            } else if (!_constant) {

                if (v.content.toString().contains(match)) {
                    return v;
                } else {
                    continue;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;


    }

    private static @NotNull Object EQUALS_ANY (String match) {

        Object output = new Object();


        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.name.equals(match) || c.content.toString().equals(match)) {
                    return c;
                }


            } else if (!_constant) {

                if (v.name.equals(match) || v.content.toString().equals(match)) {
                    return v;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;
    }

    private static @NotNull Object EQUALS_CONTENT (String match) {

        Object output = new Object();


        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.content.toString().equals(match)) {
                    return c;
                }


            } else if (!_constant) {

                if (v.content.toString().equals(match)) {
                    return v;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;
    }

    private static @NotNull Object EQUALS_NAME (String match) {

        Object output = new Object();


        // For each object in [variables]
        for (Object o : variables) {

            Variable v = null;
            Constant c = null;

            // TRUE if it's a constant, FALSE if it's a variable
            Boolean _constant;


            if (o.getClass() == Variable.class) { // If o is a variable
                v = (Variable) o; // Set v to o
                _constant = false; // Set _constant to FALSE
            } else if (o.getClass() == Constant.class) { // If o is a constant
                c = (Constant) o; // Set c to o
                _constant = true; // Set _constant to TRUE
            } else {
                throw new IllegalStateException("Only variables and constants should be in [variables].");
            }


            if (_constant) {

                if (c.name.equals(match)) {
                    return c;
                } else {
                    continue;
                }


            } else if (!_constant) {

                if (v.name.equals(match)) {
                    return v;
                } else {
                    continue;
                }

            } else {
                throw new IllegalStateException("Boolean should be true or false.");
            }



        }

        System.out.println("No match found.");

        return Result.NOT_FOUND;
    }

    // END VARIABLE HANDLING

}

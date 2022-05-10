/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter.resources;

public class Variable {

    public final String name;

    public Object content;

    public VariableTyping type;

    public Variable (String name, Object content, VariableTyping type) {
        this.name = name;
        this.content = content;
        this.type = type;
    }

    @Override public String toString () {
        return "{name: \"" + name + "\", content: \"" + content + "\", type: \"" + type + "\"}";
    }

    public String toString_objective () {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public Boolean validate () {

        if (this.name.matches("/[!@#$%^&*()+={};:\"',.<>?/|]/")) {
            System.out.println("Variable name is invalid: " + this.name);
            return false;
        }


        switch (this.type) {
            case ANY -> {
                System.out.println("Variable type is ANY, content checks will not be run.");
                return true;
            }
            case INTEGER -> {
                if (this.content.getClass() == Integer.class) {
                    System.out.println("Variable type is INTEGER. Content is valid.");
                    return true;
                } else {
                    System.out.println("Variable type is INTEGER. Content is invalid.");
                    return false;
                }
            }
            case DOUBLE -> {
                if (this.content.getClass() == Double.class) {
                    System.out.println("Variable type is DOUBLE. Content is valid.");
                    return true;
                } else {
                    System.out.println("Variable type is DOUBLE. Content is invalid.");
                    return false;
                }
            }
            case STRING -> {
                if (this.content.getClass() == String.class) {
                    System.out.println("Variable type is STRING. Content is valid.");
                    return true;
                } else {
                    System.out.println("Variable type is STRING. Content is invalid.");
                    return false;
                }
            }
            case BOOLEAN -> {
                if (this.content.getClass() == Boolean.class) {
                    System.out.println("Variable type is BOOLEAN. Content is valid.");
                    return true;
                } else {
                    System.out.println("Variable type is BOOLEAN. Content is invalid.");
                    return false;
                }
             }
            case CHARACTER -> {
                if (this.content.getClass() == Character.class) {
                    System.out.println("Variable type is CHARACTER. Content is valid.");
                    return true;
                } else {
                    System.out.println("Variable type is CHARACTER. Content is invalid.");
                    return false;
                }
            }
            default -> {
                System.out.println("Nonexistent variable type: " + this.type);
                return false;
            }
        }

    }

    protected Variable (String name) {
        this.name = name;
    }
}


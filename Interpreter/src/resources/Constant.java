/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package resources;

public final class Constant extends Variable {

    public final String name;

    public final Object content;

    public final VariableTyping type;

    public Constant(String name, Object content, VariableTyping type) {
        super(name);
        this.name = name;
        this.content = content;
        this.type = type;
    }


}

/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */


import java.util.Random;

/**
 * <p>ANSI Color codes for HorseScript.</p>
 * <p>The default color code is white.</p>
 * <br><br>
 *
 * @since 0.0.1
 * @author HorseScript
 * */
public final class c {


    /** <p>Set color to <b>White</b>.</p>
     * <p>This is the default color.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String white = "\u001B[0m";


    /** <p>Set color to <b>Black</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String black = "\u001B[30m";


    /** <p>Set color to <b>Red</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String red = "\u001B[31m";


    /** <p>Set color to <b>Green</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String green = "\u001B[32m";


    /** <p>Set color to <b>Yellow</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String yellow = "\u001B[33m";


    /** <p>Set color to <b>Blue</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String blue = "\u001B[34m";


    /** <p>Set color to <b>Purple</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String purple = "\u001B[35m";


    /** <p>Set color to <b>Cyan</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String cyan = "\u001B[36m";


    /** <p>Set color to <b>Gray</b>.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static final String gray = "\u001B[37m";




    /** <strong>This class cannot be initialized.</strong>
     *
     *
     * <br><br><br>
     * Class info:
     * <br>
     * <p>ANSI Color codes for HorseScript.</p>
     * <p>The default color code is white.</p>
     * <br><br>
     *
     * @since 0.0.1
     * @author HorseScript
     * */
    private c () {}


    /** <p>Return a random color code.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static String random () {

        String[] colors = {white, black, red, green, yellow, blue, purple, cyan, gray};

        return colors[new Random().nextInt(colors.length)];
    }


    /** <p>Return a random bright and colorful color code.</p>
     *
     * <br><br>
     * @since 0.0.1
     * @author HorseScript
     * */
    public static String randomHigh () {

        String[] colors = {red, green, yellow, blue, purple, cyan};

        return colors[new Random().nextInt(colors.length)];
    }



}

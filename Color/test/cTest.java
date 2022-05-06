/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

import org.junit.jupiter.api.Test;
import c.c;

class cTest {


    @Test void normalText () {

        System.out.println("This is unmodified text.");
    }


    @Test void whiteText () {

        System.out.println(c.white + "This is white text.");
    }


    @Test void blackText () {

        System.out.println(c.black + "This is black text.");
    }


    @Test void redText () {

        System.out.println(c.red + "This is red text.");
    }


    @Test void greenText () {

        System.out.println(c.green + "This is green text.");
    }


    @Test void yellowText () {

        System.out.println(c.yellow + "This is yellow text.");
    }


    @Test void blueText () {

        System.out.println(c.blue + "This is blue text.");
    }


    @Test void purpleText () {

        System.out.println(c.purple + "This is purple text.");
    }


    @Test void cyanText () {

        System.out.println(c.cyan + "This is cyan text.");
    }


    @Test void grayText () {

        System.out.println(c.gray + "This is gray text.");
    }


    @Test void randomText () {

        for (int i = 0; i < 10; i++) {
            System.out.println(c.random() + "This is random colored text.");
        }

    }


    @Test void randomHighText () {

        for (int i = 0; i < 10; i++) {
            System.out.println(c.randomHigh() + "This is random colorful colored text.");
        }

    }





}

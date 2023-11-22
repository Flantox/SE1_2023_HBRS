package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest1() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "eins");
    }

    @Test
    void aPositiveTest2() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(10);
        assertEquals(value, "zehn");
    }

    @Test
    void aNegativeTest1() {
        GermanTranslator translator = new GermanTranslator();
        assertThrows(InputMismatchException.class, () -> translator.translateNumber(0));
    }

    @Test
    void aNegativeTest2() {
        GermanTranslator translator = new GermanTranslator();
        assertThrows(InputMismatchException.class, () -> translator.translateNumber(11));
    }
}
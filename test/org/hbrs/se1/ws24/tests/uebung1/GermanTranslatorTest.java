package org.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

class GermanTranslatorTest {

    @Test
    void translateNumber() {
        GermanTranslator translator = new GermanTranslator();

        //grenzwert
        assertEquals("Übersetzung der Zahl 0 nicht möglich [1.0]" , translator.translateNumber(0));

        //pos
        assertEquals("fünf",translator.translateNumber(5));

        //neg1
        assertEquals("Übersetzung der Zahl -1 nicht möglich [1.0]", translator.translateNumber(-1));

        //neg2
        assertEquals("Übersetzung der Zahl 11 nicht möglich [1.0]", translator.translateNumber(11));
        // bessere Lösung wenn man für jede Äquivalenzklasse eine seperate Testmethode hat

    }


}
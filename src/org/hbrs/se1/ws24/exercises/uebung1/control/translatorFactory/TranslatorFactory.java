package org.hbrs.se1.ws24.exercises.uebung1.control.translatorFactory;
import org.hbrs.se1.ws24.exercises.uebung1.control.*;

public class TranslatorFactory {

    public static Translator generateGermanTranslator() {
        return new GermanTranslator();
    }
}

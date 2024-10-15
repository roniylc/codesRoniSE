package org.hbrs.se1.ws24.exercises.uebung1.view;
import org.hbrs.se1.ws24.exercises.uebung1.control.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.translatorFactory.*;

public class Client {

	private Translator translator;

	public Client(Translator trs){
		this.translator = trs;
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}

	/**
	 * Methode zur Ausgabe einer Zahl auf der Console
	 * (auch bezeichnet als CLI, Terminal)
	 *
	 */


	public static void display( int aNumber ){
        /* In dieser Methode soll die Methode translateNumber
        mit dem übergegebenen Wert der Variable aNumber
        aufgerufen werden.
        Strenge Implementierung (nur) gegen das Interface Translator gewuenscht! */

		Translator trs = TranslatorFactory.generateGermanTranslator();
		String ausgabe = trs.translateNumber(aNumber);

		System.out.println("Das Ergebnis der Berechnung: " +
				aNumber + " -> " + ausgabe);

	}

}
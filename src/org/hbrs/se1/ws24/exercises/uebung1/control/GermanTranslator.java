package org.hbrs.se1.ws24.exercises.uebung1.control;

import java.util.Objects;

public class GermanTranslator implements Translator {

	public String date; // Default-Wert
	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		String [] numbers = {
				"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn"
		};
		try {
			// fängt ab 0 an zu zählen
			return numbers[number - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Übersetzung der Zahl "+ number + " nicht " +
					"möglich " + "[" + Translator.version + "]";
		}
	}
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}
	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GermanTranslator that = (GermanTranslator) o;
		return Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(date);
	}
}
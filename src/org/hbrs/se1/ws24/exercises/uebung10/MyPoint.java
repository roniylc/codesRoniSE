package org.hbrs.se1.ws24.exercises.uebung10;

public class MyPoint {
    private double x; // X-Koordinate
    private double y; // Y-Koordinate

    // Konstruktor
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter-Methoden
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Überschreiben der equals-Methode für Vergleichbarkeit
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Gleiche Referenz
        if (obj == null || getClass() != obj.getClass()) return false; // Unterschiedliche Klassen

        MyPoint other = (MyPoint) obj;
        return Double.compare(other.x, x) == 0 &&
                Double.compare(other.y, y) == 0;
    }

    // Überschreiben der toString-Methode
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

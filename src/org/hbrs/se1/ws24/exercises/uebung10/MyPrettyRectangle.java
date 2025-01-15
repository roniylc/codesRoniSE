package org.hbrs.se1.ws24.exercises.uebung10;

public class MyPrettyRectangle {
    private double x1; // Linke untere Ecke (x-Koordinate)
    private double y1; // Linke untere Ecke (y-Koordinate)
    private double x2; // Rechte obere Ecke (x-Koordinate)
    private double y2; // Rechte obere Ecke (y-Koordinate)

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        if (x1 > x2 || y1 > y2) {
            throw new IllegalArgumentException("Ungültige Koordinaten: x1 < x2 und y1 < y2 erforderlich");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    // Getter-Methoden
    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    // Methode: Überprüfung, ob ein anderes Rechteck vollständig enthalten ist
    public boolean contains(MyPrettyRectangle other) {
        return this.x1 <= other.x1 && this.y1 <= other.y1 &&
                this.x2 >= other.x2 && this.y2 >= other.y2;
    }

    // Methode: Berechnung des Mittelpunkts
    public MyPoint getCenter() {
        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        return new MyPoint(centerX, centerY);
    }

    // Methode: Berechnung der Fläche
    public double getArea() {
        return (x2 - x1) * (y2 - y1);
    }

    // Methode: Berechnung des Umfangs
    public double getPerimeter() {
        double width = x2 - x1;
        double height = y2 - y1;

        System.out.println("Width: " + width + ", Height: " + height);
        System.out.println("Perimeter: " + (2 * (width + height)));

        return 2 * (width + height);
    }





    // Überschreiben der toString-Methode
    @Override
    public String toString() {
        return "Rectangle [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
    }
}

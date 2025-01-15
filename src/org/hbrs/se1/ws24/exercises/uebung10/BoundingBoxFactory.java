package org.hbrs.se1.ws24.exercises.uebung10;

public class BoundingBoxFactory {

    public static MyPrettyRectangle getBoundingBox(MyPrettyRectangle[] rectangles) {
        // Prüfen, ob das Array null ist oder keine Rechtecke enthält
        if (rectangles == null || rectangles.length == 0) {
            System.out.println("DEBUG: Kein gültiges Rechteck gefunden. Rückgabe: (0, 0, 0, 0)");
            return new MyPrettyRectangle(0, 0, 0, 0); // Null-Rechteck zurückgeben
        }

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        boolean validRectangleFound = false;

        // Schleife durch alle Rechtecke und berechne die minimalen/maximalen Werte
        for (MyPrettyRectangle rect : rectangles) {
            if (rect != null) {
                validRectangleFound = true;
                minX = Math.min(minX, rect.getX1());
                minY = Math.min(minY, rect.getY1());
                maxX = Math.max(maxX, rect.getX2());
                maxY = Math.max(maxY, rect.getY2());
            }
        }

        // Wenn kein gültiges Rechteck gefunden wurde, ein Null-Rechteck zurückgeben
        if (!validRectangleFound) {
            System.out.println("DEBUG: Kein gültiges Rechteck im Array. Rückgabe: (0, 0, 0, 0)");
            return new MyPrettyRectangle(0, 0, 0, 0);
        }

        // Überprüfen, ob die berechneten Werte gültig sind
        if (minX >= maxX || minY >= maxY) {
            System.out.println("DEBUG: Fehlerhafte Bounding Box-Koordinaten berechnet.");
            throw new IllegalArgumentException("Ungültige Koordinaten: x1 < x2 und y1 < y2 erforderlich");
        }

        // Rückgabe der Bounding Box
        System.out.printf("DEBUG: Berechnete Bounding Box - minX=%.2f, minY=%.2f, maxX=%.2f, maxY=%.2f%n",
                minX, minY, maxX, maxY);
        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }




}

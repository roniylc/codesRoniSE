package org.hbrs.se1.ws24.exercises.uebung9;

public class TestClient {

    public static void main(String[] args){
        ComplexDocument  doc0 = new ComplexDocument();
        doc0.setID(1);

        Document doc1 = new TextDocument("Die Klausur im Fach SE findet bald statt!", TextDocument.Encoding.UTF8);
        doc1.setID(3);

        ComplexDocument doc2 = new ComplexDocument();
        doc2.setID(1);

        Document doc3 = new GraficDocument("localhost:8080");
        doc3.setID(2);

        Document doc4 = new TextDocument("Software Engineering I ist eine Vorlesung " +
                "in den Studiengaengen BIS und BCS", TextDocument.Encoding.UTF32);
        doc4.setID(3);

        doc2.addDocument(doc3);
        doc2.addDocument(doc4);
        doc0.addDocument(doc2);
        doc0.addDocument(doc1);

        System.out.println("Size of Docs: " + doc0.size() + " Bytes");
    }

}

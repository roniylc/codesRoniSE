package org.hbrs.se1.ws24.exercises.uebung9;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends AbstractDocument {

    private List<Document> list = new ArrayList<>();

    public void addDocument(Document d) {
        if (this.list == null) {
            this.list = new ArrayList<Document>();
        }
        this.list.add(d);

    }

    public void removeDocument(Document d) {
        if (this.list != null) {
            this.list.remove(d);
        }
    }

    @Override
    public int size() {
        int gesamtByte = 0;
        for(Document d : list) {
            gesamtByte += gesamtByte + d.size();
        }
        return gesamtByte;
    }
}

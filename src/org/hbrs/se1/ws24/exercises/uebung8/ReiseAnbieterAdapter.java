package org.hbrs.se1.ws24.exercises.uebung8;

public class ReiseAnbieterAdapter implements ExternalHotelSucheInterface {

    private ReiseAnbieter system;

    @Override
    public SuchErgebnis suche(SuchAuftrag suche){
        QueryObject q = this.transformInput(suche);
        QueryResult r = system.executeQuery(q);
        SuchErgebnis se = this.transformOut(r);

        return se;
    }

    private QueryObject transformInput(SuchAuftrag s){
        return null;
    }
    private SuchErgebnis transformOut(QueryResult r){
        return null;
    }
}
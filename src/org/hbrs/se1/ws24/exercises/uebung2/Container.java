package org.hbrs.se1.ws24.exercises.uebung2;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static Container instance; // static für Singleton-Instanz
    private List<Member> list;
    private PersistenceStrategy<Member> strategy;  // zum persistenten speichern

    // private, damit externe Instanziierung verhindert wird
    private Container(){
        list = new ArrayList<Member>();
    }

    // erzeugt einzige Instanz von Container
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }

    public void setPersistenceStrategy (PersistenceStrategy<Member> strategy){
        this.strategy = strategy;
    }

    public void store() throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine PersistenceStrategy gesetzt");
        }
        strategy.save(list);
    }

    public void load() throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine PersistenceStrategy gesetzt");
        }
        List<Member> loadedList = strategy.load();
        if (loadedList != null) {
            list = loadedList;
        }
    }

    public void addMember(Member member) throws ContainerException{
        // hier wird ueberprueft ob das memberobjekt bereits vorhanden ist
        for (Member m : list) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + m.getID() + " ist bereits\n" +
                        "vorhanden!");
            }
        }
        list.add(member);
    }

    public String deleteMember(int ID) {
        for (Member m : list) {
            if (m.getID() == ID) {
                list.remove(m);
                return "Entfernen erfolgreich!";
            }
        }
        return "Member-Objekt mit der ID = " + ID + " existiert nicht";
    }

    public int size(){
        return list.size();
    }

    public List<Member> getCurrentList() {
        return list;
    }

}

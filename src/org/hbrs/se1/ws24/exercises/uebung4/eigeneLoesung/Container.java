package org.hbrs.se1.ws24.exercises.uebung4.eigeneLoesung;
import org.hbrs.se1.ws24.exercises.uebung4.eigeneLoesung.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;



public class Container<T extends Comparable<T>> {
    /* Singleton Pattern: Garantiert, dass nur eine Instanz von Container existiert
    * Konstruktor private, damit von außen eine erzeugung nicht möglich ist, static variable für die
    * Singleton-Instanz, in der dann in einer static methode die einzige Instanz erzeugt wird
    * */

    private static Container instance; // static für Singleton-Instanz
    private ArrayList<T> list;
    private PersistenceStrategy<T> strategy;  // zum persistenten speichern

    // private, damit externe Instanziierung verhindert wird
    private Container(){
        list = new ArrayList<T>();
        this.strategy = new PersistenceStrategyStream<T>();
    }

    // erzeugt einzige Instanz von Container
    /* Vorteil: Erstellung des Objektes bei Bedarf
    *  Nachteil: Thread-Safe? Nein! (Lösung: Synchronized, aber erheblich schlecht bei der Performance)
    * */
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }

    public void setPersistenceStrategy (PersistenceStrategy<T> strategy){
        this.strategy = strategy;
    }

    public void store() throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine Strategy ausgewählt");
        }
        try {
            strategy.save(list);
        } catch (org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine PersistenceStrategy gesetzt");
        }
        list = (ArrayList<T>) strategy.load();
    }

    public void addUserStory(T e) throws ContainerException {
        // hier wird ueberprueft ob die UserStory bereits vorhanden ist
        if(list.contains(e)){
            ContainerException exception = new ContainerException("Diese UserStory ist bereits vorhanden");
            throw exception;
        }
        list.add(e);
    }

    public void deleteUserStory(T e) throws ContainerException {
        // hier wird ueberprueft ob die UserStory existiert
        if(!list.contains(e)){
            ContainerException exception = new ContainerException("Diese UserStory ist nicht vorhanden");
            throw exception;
        }
        list.remove(e);
    }

    public void dump() {
        Collections.sort(list);
        for(T e : list){
            System.out.println(e);
        }
    }

    public int size(){
        return list.size();
    }

    public List<T> getCurrentList() {
        return list;
    }

    Scanner scanner = new Scanner(System.in);

    public void eingabe() throws PersistenceException, ContainerException {

        String strInput = null;
        System.out.print("Befehl eingeben");
        boolean running = true;

        while (running) {
            System.out.print("> ");
            strInput = scanner.nextLine();

            String[] strings = strInput.split(" ");
            if (strings[0].equals("help")){
                System.out.println("Mögliche Befehle: help, store, load, dump, exit, enter(Bitte in Folgender Reihenfolge angeben: ID,Title,Akzeptanzbedingung,Projekt,Mehrwert,Strafe,Aufwand,Risiko)");

            }

            if (strings[0].equals("exit")){
                running = false;
            }

            if (strings[0].equals("store")){
                instance.store();
            }

            if (strings[0].equals("load")){
                instance.load();
            }

            if (strings[0].equals("dump")){
                instance.dump();
            }

            if (strings[0].equals("enter")){
                instance.addUserStory(new UserStory(Integer.parseInt(strings[1]),strings[2],strings[3],strings[4],
                        Double.parseDouble(strings[5]), Double.parseDouble(strings[6]), Double.parseDouble(strings[7]), Double.parseDouble(strings[8])));
            }
        }
    }


}

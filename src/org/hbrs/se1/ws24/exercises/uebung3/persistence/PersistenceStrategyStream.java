package org.hbrs.se1.ws24.exercises.uebung3.persistence;
import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help!
     */
    public void save(List<E> member) throws PersistenceException  {
        try {
            FileOutputStream fos = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(member); // schreibt Objekt in File
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"Fehler beim Speichern der Daten: " + e.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        try {
            FileInputStream fis = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if(obj instanceof List<?>) {
                return (List<E>) obj;
            } else {
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Geladene Datei enthält keine Liste");
            }

        } catch (FileNotFoundException e) { // Falls die Datei nicht existiert
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Datei nicht gefunden: " + e.getMessage());

        } catch (IOException | ClassNotFoundException e) {
            // Andere I/O-Fehler oder Fehler beim Lesen des Objekts
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Laden der Daten: " + e.getMessage());
        }
    }
}

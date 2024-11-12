package org.hbrs.se1.ws24.exercises.uebung4.eigeneLoesung;
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
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 15th 2024)
     */
    public void save(List<E> t) throws PersistenceException {
        ObjectOutputStream oos;
        try {
            FileOutputStream fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(t); // schreibt Objekt in File
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"Fehler beim Speichern der Daten: " + e.getMessage());
        }
        try {
            oos.close();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"Fehler beim Schließen: " + e.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();

            if(obj instanceof List<?>) {
                return (List<E>) obj;
            } else {
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Geladene Datei enthält keine Liste ");
            }

        } catch (ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,
                    "Klasse nicht gefunden: " + e.getMessage());

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Laden der Daten: " + e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Input Stream konnte nicht geschlossen werden " + e.getMessage());
            }
        }
    }
}

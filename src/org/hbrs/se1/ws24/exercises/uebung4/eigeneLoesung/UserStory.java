package org.hbrs.se1.ws24.exercises.uebung4.eigeneLoesung;
import java.io.*;

public class UserStory implements Comparable<UserStory>, Serializable {
    // ToDo: Sind die Attribute der Klasse UserStory vollständig? Wie sieht es mit den
    //  Sichtbarkeiten aus? (F4)

    String titel;
    int id = 0;
    double prio = 0.0;
    String project;
    String acceptance;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public UserStory(int id, String titel, String acceptance, String project, double mwert, double strafe, double aufwand, double risiko) {
        this.id = id;
        this.titel = titel;
        setPrio(mwert, strafe, aufwand, risiko);
        this.acceptance = acceptance;
        this.project = project;
    }


    public double getPrio() {
        return prio;
    }

    public void setPrio(double mwert, double strafe, double aufwand, double risiko) {
        if(mwert < 0 | strafe < 0 | aufwand < 0 | risiko < 0)
            throw new NumberFormatException("nur positive Zahlen erlaubt");
        this.prio = (mwert + strafe)/(aufwand + risiko);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(UserStory o) {
        return Double.compare(this.prio, o.prio);
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "ID=" + id +
                ", Titel='" + titel + '\'' +
                ", Priorität='" + prio +
                ", Acceptance='" + acceptance + '\'' +
                ", Projekt='" + project + '\'' +
                "}";
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }
}

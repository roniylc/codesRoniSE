package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.ArrayList;

public class Container {

    private ArrayList<Member> list;

    public Container(){
        list = new ArrayList<Member>();
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

    public void dump(){
        for (Member m : list) {
            System.out.println(m.toString());
        }
    }

    public int size(){
        return list.size();
    }

}

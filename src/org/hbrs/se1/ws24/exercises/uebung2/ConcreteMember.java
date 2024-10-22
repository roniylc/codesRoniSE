package org.hbrs.se1.ws24.exercises.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {

    private int ID;

    public ConcreteMember(int id){
        this.ID = id;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Member (ID=" + this.getID() + ')';
    }
}
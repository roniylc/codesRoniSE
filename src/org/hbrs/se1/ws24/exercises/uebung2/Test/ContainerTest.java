package org.hbrs.se1.ws24.exercises.uebung2.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.junit.jupiter.api.*;

public class ContainerTest {

    private static Container c;

    @BeforeEach
    void init() throws ContainerException {
        c = new Container();
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        c.addMember(m1);
        c.addMember(m2);
    }

    // Testet addMember(Member) methode
    @Test
    void test1() throws ContainerException {
        // pos addMember() test
        Member m = new ConcreteMember(3);
        c.addMember(m);
        assertEquals(3,c.size());
        // neg addMember() test --> mit gleicher ID
        Member m4 = new ConcreteMember(2);
        ContainerException thrown = assertThrows(ContainerException.class, () -> { c.addMember(m4);});
        assertEquals("Das Member-Objekt mit der ID 2 ist bereits\nvorhanden!", thrown.getMessage());

    }

    // Testet deleteMember(int) methode
    @Test
    void test2() throws ContainerException {
        // pos deleteMember() test
        Member m3 = new ConcreteMember(3);
        c.deleteMember(3);
        assertEquals(2,c.size());
        // neg deleteMember() test mit falscher ID oder wenn es keine Member gibt
        c.deleteMember(20);
        assertEquals("Member-Objekt mit der ID = " + 20 + " existiert nicht", c.deleteMember(20));
    }

    // delete wenn keine Member, Wenn man null übergibt, Mit mehreren membern bei add und delete, Container leer beim erzeugen,

    // testet dump() methode
    @Test
    void test3() {

    }

    // testet size() methode
    @Test
    void test4() throws ContainerException {
        // pos size() test
        assertEquals(2,c.size());
        // pos size() nach addMember(Member)
        Member m1 = new ConcreteMember(3);
        c.addMember(m1);
        assertEquals(3,c.size());
        // pos size() test nach deleteMember(int)
        c.deleteMember(2);
        c.deleteMember(1);
        assertEquals(1,c.size());
    }

}
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

    @Test
    void test1() throws ContainerException {
        // pos addMember() test
        Member m = new ConcreteMember(3);
        c.addMember(m);
        assertEquals(3,c.size());
        // neg addMember() test --> mit gleicher ID
        Member m4 = new ConcreteMember(1);
        ContainerException thrown = assertThrows(ContainerException.class, () -> { c.addMember(m4);});
        assertEquals("Das Member-Objekt mit der ID 1 ist bereits\nvorhanden!", thrown.getMessage());

    }

    @Test
    void test2() throws ContainerException {
        // pos deleteMember() test
        c.deleteMember(1);
        assertEquals(1,c.size());
        // neg deleteMember() test mit falscher ID oder wenn es keine Member gibt
        c.deleteMember(3);
        assertEquals("Member-Objekt mit der ID = " + 3 + " existiert nicht", c.deleteMember(3));
    }

    @Test
    void test3(){
        Container c2 = new Container();
        c2.deleteMember(1);
        assertEquals("Member-Objekt mit der ID = " + 1 + " existiert nicht", c2.deleteMember(1));
    }

    @Test
    void test4() throws ContainerException {
        Member m3 = new ConcreteMember(3);
        Member m4 = new ConcreteMember(4);
        Member m5 = new ConcreteMember(5);
        c.addMember(m3);
        c.addMember(m4);
        c.addMember(m5);
        assertEquals(5,c.size());
    }

    @Test
    void test5() throws ContainerException {
        Container c2 = new Container();
        Member m3 = new ConcreteMember(3);
        Member m4 = new ConcreteMember(4);
        Member m5 = new ConcreteMember(5);
        c2.addMember(m3);
        c2.addMember(m4);
        c2.addMember(m5);
        c2.deleteMember(3);
        c2.deleteMember(4);
        c2.deleteMember(5);
        assertEquals(0,c2.size());
    }

    @Test
    void test6() throws ContainerException {
        Member m3 = new ConcreteMember(3);
        c.addMember(m3);
        c.deleteMember(3);
        assertEquals(2,c.size());
    }

    @Test
    void test7() {
        Container c2 = new Container();
        assertEquals(0,c2.size());
    }

    @Test
    void test8() throws ContainerException {
        c.dump();
        assertEquals(2,c.size());
    }

}
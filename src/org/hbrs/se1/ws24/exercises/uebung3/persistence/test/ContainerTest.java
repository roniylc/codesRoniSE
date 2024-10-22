package org.hbrs.se1.ws24.exercises.uebung3.persistence.test;
import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    private PersistenceStrategyStream<Member> s;
    private PersistenceStrategyMongoDB<Member> m;
    private Container c;

    @BeforeEach
    void init(){
        c = Container.getInstance();
        c.getCurrentList().clear();
    }

    @Test
    public void StrategyTest() {
        assertThrows(PersistenceException.class,c::store);
    }

    @Test
    public void MongoDBTest(){
        m = new PersistenceStrategyMongoDB<>();
        c.setPersistenceStrategy(m);
        assertThrows(UnsupportedOperationException.class, c::store);
    }

    @Test
    public void LocationTest(){
        s = new PersistenceStrategyStream<>();
        s.setLocation("/does/not/exist");
        c.setPersistenceStrategy(s);
        assertThrows(PersistenceException.class,c::store);
    }

    @Test
    public void RoundTripTest() throws ContainerException, PersistenceException {
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);

        c.addMember(m1);
        c.addMember(m2);
        assertEquals(2,c.size());

        s = new PersistenceStrategyStream<>();
        c.setPersistenceStrategy(s);
        c.store();
        c.load();
        assertEquals(2,c.size());

        c.deleteMember(1);
        c.deleteMember(2);
        assertEquals(0,c.size());

        c.load();
        assertEquals(2,c.size());
    }
}
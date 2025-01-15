package org.hbrs.se1.ws24.tests.uebung10;
import org.hbrs.se1.ws24.exercises.uebung10.LimitedStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitedStackTest {
    private LimitedStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new LimitedStack<>(4); // Maximale Größe von 4
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPartiallyFilledStack() {
        stack.push(1);
        stack.push(2);

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    public void testFullStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.size());
        assertThrows(IllegalStateException.class, () -> stack.push(5));
    }

    @Test
    public void testPopFromStack() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}

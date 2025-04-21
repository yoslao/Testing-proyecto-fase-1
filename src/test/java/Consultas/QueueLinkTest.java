package Consultas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class QueueLinkTest {


    @Test
    public void testEnqueueDequeue() {
        QueueLink<String> cola = new QueueLink<>();
        cola.enqueue("A");
        cola.enqueue("B");

        assertEquals("A", cola.dequeue());
        assertEquals("B", cola.dequeue());
        assertNull(cola.dequeue());
    }


    @Test
    public void testCountYisEmpty() {
        QueueLink<Integer> cola = new QueueLink<>();
        cola.enqueue(10);
        cola.enqueue(20);

        assertEquals(2, cola.count());
        assertFalse(cola.isEmpty());

        cola.dequeue();
        cola.dequeue();

        assertTrue(cola.isEmpty());
    }
}


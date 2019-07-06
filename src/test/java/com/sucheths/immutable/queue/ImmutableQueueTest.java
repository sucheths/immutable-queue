package com.sucheths.immutable.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * test class of ImmutableQueue
 * 
 * @author sucheth.shivakumar
 */
public class ImmutableQueueTest {
    
    private final List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void enQueueShoudlReturnNewQueueInstanceWithNewElementAdded(){

        Queue<Integer> queue = new ImmutableQueue<>();

        for (Integer i : data){
            Queue<Integer> old_queue = queue;
            queue = queue.enQueue(i);
            assertNotSame(old_queue, queue);
        };
    }

    @Test
    public void deQueueShouldReturnANewQueueInstanceWithTopElementRemoved(){

        Queue<Integer> queue = new ImmutableQueue<>();
        for (Integer i : data) {
            queue = queue.enQueue(i);
        }

        Queue<Integer> old_queue = queue;
        queue = queue.deQueue();
        assertNotSame(old_queue, queue);
        assertSame(queue.head(), data.get(1));

    }

    @Test
    public void getHeadShouldReturnTheFirstElementInQueue(){

        Queue<Integer> queue = new ImmutableQueue<Integer>();
        for (Integer i : data){
            queue = queue.enQueue(i);
        };

        assertSame(queue.head(), data.get(0));
    }

}

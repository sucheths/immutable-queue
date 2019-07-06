package com.sucheths.immutable.queue;

import java.lang.reflect.Executable;

/**
 * Immutable queue interface
 * 
 * @author sucheth.shivakumar
 */
public interface Queue<T> {

    /**
     * @param t generic type to be inserted to the queue
     * @return a new queue after inserting element t of generic type T
     */
    public Queue<T> enQueue(T t);

    /**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     * @return
     */
    public Queue<T> deQueue();

    /**
     * returns head element of the queue
     * 
     * @return
     * @throws Exception
     */
    public T head();

    /**
     * returns true if the queue is empty, else returns false
     * 
     * @return
     */
    public boolean isEmpty();
}

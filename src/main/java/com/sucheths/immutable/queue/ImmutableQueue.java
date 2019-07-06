package com.sucheths.immutable.queue;

import java.util.NoSuchElementException;

/**
 * immutable queue implementation class
 *
 * @author sucheth.shivakumar
 */
public final class ImmutableQueue<T> implements Queue<T> {


    private static final class Stack<T> {

        private T head;
        private Stack<T> tail;
        private int size;

        /**
         * Default constructor
         */
        private Stack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /**
         * Constructor Overloading
         *
         * @param obj
         * @param tail
         */
        private Stack(T obj, Stack<T> tail) {
            this.head = obj;
            this.tail = tail;
            this.size = tail.size + 1;
        }


        /**
         * Check if stack is empty
         *
         * @return true or false depending on whether stack is empty
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * Push new element into stack
         *
         * @param
         * @return Stack
         */
        public Stack<T> push(T obj) {
            return new Stack<>(obj, this);
        }

        /**
         * Reverse the order of the stack
         *
         * @return Stack reversed stack
         */
        public Stack<T> reverseStack() {
            Stack<T> stack = new Stack<>();
            Stack<T> tail = this;
            while (!tail.isEmpty()) {
                stack = stack.push(tail.head);
                tail = tail.tail;
            }
            return stack;
        }
    }

    private Stack<T> forward;
    private Stack<T> reverse;

    /**
     * Constructor
     * <p>
     * Create 2 Stack objects for opposite ordering of queue elements
     */
    public ImmutableQueue() {
        this.forward = new Stack<>();
        this.reverse = new Stack<>();
    }

    /**
     * Constructor overloading
     *
     * @param forward
     * @param reverse
     */
    public ImmutableQueue(Stack<T> forward, Stack<T> reverse) {
        this.forward = forward;
        this.reverse = reverse;
    }

    /**
     * Add object to queue
     * Throws IllegalArgumentException
     *
     * @return ImmutableQueue
     */
    public Queue<T> enQueue(T object) {
        if (object != null) {
            return new ImmutableQueue<>(this.forward.push(object), this.reverse);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Reverse the "forward" stack, and assign
     * new stack to the "reverse" instance variable.
     * Used by the "head" to obtain the first element
     * in the queue
     */
    private void forwardToReverse() {
        this.reverse = this.forward.reverseStack();
        this.forward = new Stack<>();
    }

    /**
     * Remove the first element in the queue
     *
     * @return Queue
     */
    public Queue<T> deQueue() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (!this.reverse.isEmpty()) {
            return new ImmutableQueue<>(this.forward, this.reverse.tail);
        } else {
            return new ImmutableQueue<>(new Stack<>(), this.forward.reverseStack().tail);
        }
    }

    /**
     * Return the first element in the queue
     *
     * @return T first element
     */
    public T head() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (this.reverse.isEmpty())
            forwardToReverse();
        return this.reverse.head;
    }
  
    /**
     * Get queue size (equal to length of forward + reverse stack)
     *
     * @return boolean queue size
     */
    public boolean isEmpty() {
        return this.forward.size + this.reverse.size == 0;
    }
    
}

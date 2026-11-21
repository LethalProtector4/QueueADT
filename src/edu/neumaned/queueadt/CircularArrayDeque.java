package edu.neumaned.queueadt;

import java.util.NoSuchElementException;

/**
 * PART 1: A deque stored in a CIRCULAR ARRAY.
 *
 * Team members: Kengo Hudson, Everett Neumann, Fadhili Kizito, Matthew Astahoff, James Shubert
 *
 * Rules:
 *  - Use the fields below: an array, frontIndex (index of the front item) and size.
 *  - Every operation must be O(1), except that a full array may be resized (doubled).
 *  - When the array is full, double its length. Copy the items IN DEQUE ORDER into the
 *    new array, starting at index 0, and set frontIndex = 0.
 *  - addToFront must move frontIndex BACKWARDS, wrapping from 0 to length - 1.
 *  - removeFront / removeBack / peekFront / peekBack on an empty deque must throw
 *    NoSuchElementException.
 *  - clear() must go back to a fresh array of INITIAL_CAPACITY.
 */
public class CircularArrayDeque<T> implements DequeInterface<T> {
    private static final int INITIAL_CAPACITY = 4;

    private T[] deque;
    private int frontIndex;   // index of the front item
    private int size;         // how many items are stored

    @SuppressWarnings("unchecked")
    public CircularArrayDeque() {
        deque = (T[]) new Object[INITIAL_CAPACITY];
        frontIndex = 0;
        size = 0;
    }

    /** Given: the current length of the array (used by the tester to check resizing). */
    public int capacity() {
        return deque.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addToBack(T newEntry) {
        resize();
        deque[(frontIndex + size) % deque.length] = newEntry;
        size++;
    }

    @Override
    public void addToFront(T newEntry) {
        resize();
        frontIndex = (frontIndex + deque.length - 1) % deque.length;
        deque[frontIndex] = newEntry;
        size++;
    }

    @Override
    public T peekFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return deque[frontIndex];
    }

    @Override
    public T peekBack() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return deque[(frontIndex + size + deque.length - 1) % deque.length];
    }

    @Override
    public T removeFront() {
        T temp = peekFront();
        size--;
        deque[frontIndex] = null;
        frontIndex = (frontIndex + 1) % deque.length;
        return temp;
    }

    @Override
    public T removeBack() {
        T temp = peekBack();
        size--;
        deque[(frontIndex + size) % deque.length] = null;
        return temp;
    }

    @Override
    public void clear() {
        /*
        for (int i = 0; i < deque.length; i++) {
            deque[i] = null;
        }*/
        size = 0;
        frontIndex = 0;
        deque = (T[]) new Object[INITIAL_CAPACITY];
    }

    
    private void resize() {
        if (size != deque.length) {
            return;
        }
        // deque = Arrays.copyOf(deque, 2 * deque.length);
        T[] temp = (T[]) new Object[2 * deque.length];
        for (int i = 0; i < deque.length; i++) {
            temp[i] = deque[(frontIndex + i) % deque.length];
        }
        frontIndex = 0;
        deque = temp;
    }
}

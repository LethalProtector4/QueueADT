package edu.neumaned.queueadt;

/**
 * A deque (double-ended queue): items can be added to and removed from BOTH ends.
 * Given to you. Do not change it.
 */
public interface DequeInterface<T> {
    /** Adds an entry at the front. */
    void addToFront(T newEntry);

    /** Adds an entry at the back. */
    void addToBack(T newEntry);

    /** Removes and returns the front entry. @throws java.util.NoSuchElementException if empty */
    T removeFront();

    /** Removes and returns the back entry. @throws java.util.NoSuchElementException if empty */
    T removeBack();

    /** Returns the front entry without removing it. @throws java.util.NoSuchElementException if empty */
    T peekFront();

    /** Returns the back entry without removing it. @throws java.util.NoSuchElementException if empty */
    T peekBack();

    /** @return true if there are no entries */
    boolean isEmpty();

    /** Removes all entries. */
    void clear();
}

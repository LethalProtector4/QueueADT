package edu.neumaned.queueadt;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * PART 3 (b): An emergency room waiting list.
 *
 * Team members: ______________________  ______________________  ______________________
 *
 * Use a java.util.PriorityQueue<Patient>. Each call to arrive() creates a Patient whose
 * arrival number is 1, 2, 3, ... in the order the calls happen.
 * treatNext / peekNext return the NAME of the patient who is most urgent, and throw
 * NoSuchElementException when nobody is waiting.
 */
public class TriageRoom {
    private final PriorityQueue<Patient> waiting = new PriorityQueue<>();
    private int arrivals = 0;

    public void arrive(String name, int severity) {
        // no name == null condition
        waiting.add(new Patient(name, severity, arrivals++));
    }

    public String treatNext() {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        }
        return waiting.remove().getName();
    }

    public String peekNext() {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        }
        return waiting.peek().getName();
    }

    public int size() {
        return waiting.size();
    }

    public boolean isEmpty() {
        return waiting.isEmpty();
    }
}

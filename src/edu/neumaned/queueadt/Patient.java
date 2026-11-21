package edu.neumaned.queueadt;

/**
 * PART 3 (a): A patient in the emergency room.
 *
 * Priority rule used by compareTo:
 *   1. A LOWER severity number is more urgent (1 = life threatening, 5 = minor) and comes first.
 *   2. If two patients have the same severity, the one who ARRIVED EARLIER (smaller arrival
 *      number) comes first.
 * compareTo returns a negative number if this patient should be treated BEFORE the other one,
 * a positive number if AFTER, and 0 only if both severity and arrival are equal.
 */
public class Patient implements Comparable<Patient> {
    private final String name;
    private final int severity;
    private final int arrival;

    public Patient(String name, int severity, int arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrival() {
        return arrival;
    }

    @Override
    public int compareTo(Patient other) {
        // no other == null condition
        int difference = severity - other.getSeverity();
        if (difference != 0) {
            return difference;
        }
        return arrival - other.getArrival();
    }

    @Override
    public String toString() {
        return name + " (severity " + severity + ", arrival " + arrival + ")";
    }
}

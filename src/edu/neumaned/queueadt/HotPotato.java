package edu.neumaned.queueadt;

import java.util.LinkedList;
import java.util.List;

/**
 * PART 4: Hot potato (the Josephus game) with a QUEUE.
 *
 * Team members: ______________________  ______________________  ______________________
 *
 * The players stand in a circle in the order of the list. The potato starts with the FIRST
 * player (the front of the queue). One round works like this:
 *     1. Pass the potato `passes` times. A pass moves the player at the FRONT to the BACK.
 *     2. Whoever is now at the FRONT is holding the potato: that player is OUT (removed).
 * Rounds repeat until one player is left. That player wins.
 *
 * Example: players [A, B, C, D, E], passes = 2
 *     round 1: A->back, B->back, C is out     queue: D E A B
 *     round 2: D->back, E->back, A is out     queue: B D E
 *     ...
 *
 * Required: use a java.util.Queue (a LinkedList is fine). add() and remove() only:
 * no get(i), no indexOf, no remove(index).
 */
public class HotPotato {

    /** @return the names in the order they are eliminated, winner LAST.
     *  @throws IllegalArgumentException if names is empty or passes is negative */
    public static List<String> eliminationOrder(List<String> names, int passes) {
        if (names == null || passes < 0 || names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        java.util.Queue<String> rotation = new LinkedList<>(names);
        List<String> eliminated = new LinkedList<>();
        while (!rotation.isEmpty()) {
            for (int i = 0; i < passes; i++) {
                rotation.add(rotation.remove());
            }
            eliminated.add(rotation.remove());
        }
        return eliminated;
    }

    /** @return the winner (the last player standing). Same exceptions as above. */
    public static String winner(List<String> names, int passes) {
        // assuming same assignment restrictions apply to both methods
        java.util.Queue<String> eliminated = new LinkedList<>(eliminationOrder(names, passes));
        for (int i = 1; i < names.size(); i++) {
            eliminated.add(eliminated.remove());
        }
        String temp = eliminated.remove();
        // eliminated.add(temp); to revert Queue
        return temp;
    }
}

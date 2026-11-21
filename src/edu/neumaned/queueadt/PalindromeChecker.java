package edu.neumaned.queueadt;



/**
 * PART 2: Palindrome checker using a DEQUE.
 *
 * Team members: ______________________  ______________________  ______________________
 *
 * isPalindrome(s) returns true if s reads the same forwards and backwards when you
 * IGNORE upper/lower case and ignore every character that is not a letter or a digit.
 *   "A man, a plan, a canal: Panama"  -> true
 *   "Hello"                           -> false
 *   ""                                -> true  (nothing to compare)
 *
 * Required approach: put the letters/digits (lower-cased) into a java.util.Deque<Character>
 * (for example new ArrayDeque<>() or new LinkedList<>()), then repeatedly compare the front
 * and the back until fewer than two characters remain.
 * Do NOT reverse the string, and do NOT compare s.charAt(i) with s.charAt(s.length() - 1 - i).
 * (A loop with charAt(i) is fine for FILLING the deque.)
 */
public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetter(temp) || Character.isDigit(temp)) {
                deque.add(Character.toLowerCase(temp));
            }
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
        
    }
}

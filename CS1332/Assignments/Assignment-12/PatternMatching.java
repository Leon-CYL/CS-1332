// 9.44/10 //
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      
      Map<Character, Integer> table = new HashMap<Character, Integer>();
      List<Integer> found = new ArrayList<Integer>();
      table = buildLastTable(pattern);
      int index = 0;
      
      while (index + pattern.length() <= text.length()) {
            int pIndex = pattern.length() - 1;
            while (pIndex >= 0 && comparator.compare(
                    text.charAt(index + pIndex), pattern.charAt(pIndex)) == 0) {
                pIndex--;
            }
            if (pIndex < 0) {
                found.add(index++);
            } 
            else {
                int shift = table.getOrDefault(
                    text.charAt(index + pattern.length() - 1), -1);
                if (shift < pIndex) {
                    index += pIndex - shift;
                } 
                else {
                    index++;
                }
            }
        }
      
      return found;
      
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      Map<Character, Integer> Last_Table = new HashMap<Character, Integer>();
      for (int i = 0; i < pattern.length(); i++){
        Last_Table.put(pattern.charAt(i), i);
      }
      return Last_Table;
    }
}
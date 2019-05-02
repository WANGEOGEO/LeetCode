import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q3Repeating {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        // dictionary is actually storing such a key-value pair:
        // (key: the distinct Character I found,
        // value:if I see this character in the future loop, i should be that value)
        HashMap<Character, Integer> dictionary = new HashMap<>();
        int answer = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (dictionary.containsKey(s.charAt(j))) {
                // That means, the character that is being pointed by j has been seen before.
                // Now we should make a discision: if this duplication is before current i, we should not change i.
                // If the duplicate one is discovered after current i, i should move to 1 index after the duplication.
                // this '1 index after' has been saved in the dictionary, so we can simply use it.
                i = Math.max(i, dictionary.get(s.charAt(j)));
            }
            // update the length of longest non-repeating string so far.
            answer = Math.max(answer, j - i + 1);
            // The reason for stroing j + 1 instead of j is:
            // for the convenience to direct i.
            dictionary.put(s.charAt(j), j + 1);
        }
        return answer;
    }
}

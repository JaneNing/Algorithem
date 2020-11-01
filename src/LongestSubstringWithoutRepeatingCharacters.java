import java.util.HashSet;
import java.util.Set;

/**
 * 11/1/2020
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int maxLen = 0;
        int len = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.contains(c)) {
                chars.add(c);
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                chars.remove(s.charAt(l));
                i--;
                l++;
                len--;
            }
        }
        return maxLen;
    }
}

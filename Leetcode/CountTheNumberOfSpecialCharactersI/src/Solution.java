import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet<>();
        int res = 0;

        for (char c : word.toCharArray()) {
            if (s.contains(c)) continue;
            if (c > 'Z' && s.contains((char) (c - 32)) || s.contains((char) (c + 32))) {
                res++;
            }
            s.add(c);
        }

        return res;
    }
}
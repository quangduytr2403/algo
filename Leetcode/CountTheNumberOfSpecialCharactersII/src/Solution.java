import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet<>();
        Set<Character> t = new HashSet<>();
        int res = 0;

        for (char c : word.toCharArray()) {
            if (c <= 'Z' && s.contains(c)) continue;
            if (c <= 'Z' && s.contains((char) (c + 32))) {
                res++;
                t.add(c);
            }
            if (c > 'Z' && t.contains((char) (c - 32))) {
                res--;
                t.remove((char) (c - 32));
            }
            s.add(c);
        }

        return res;
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLengthSubstring(String s) {
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> m = new HashMap<>();
        int l = 0, r = -1, t;

        while (r < s.length() - 1) {
            r++;
            m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0) + 1);
            if (m.get(s.charAt(r)) > 2) {
                while (l < r) {
                    m.put(s.charAt(l), m.get(s.charAt(l)) - 1);
                    t = l;
                    l++;
                    if (s.charAt(t) == s.charAt(r)) break;
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
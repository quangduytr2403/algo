import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestBalanced(String s) {
        Map<Character, Integer> m;
        int res = 0;
        char c;
        final int t;

        for (int i = 0; i < s.length(); i++) {
            m = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                c = s.charAt(j);
                if (!m.containsKey(c)) m.put(c, 0);
                m.put(c, m.get(c) + 1);

                if (new HashSet<>(m.values()).size() == 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}
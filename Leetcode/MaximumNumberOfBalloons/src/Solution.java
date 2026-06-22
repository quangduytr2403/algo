import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> m = new HashMap<>();
        List<Character> l = Arrays.asList('b','a','l','o','n');

        for (char c : text.toCharArray()) {
            if (l.contains(c)) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (char c : l) {
            res = Math.min(res, c == 'l' || c == 'o' ? m.getOrDefault(c, 0) / 2 : m.getOrDefault(c, 0));
        }

        return res;
    }
}
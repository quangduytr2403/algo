import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
            else m2.put(s1.charAt(i), m2.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                if (!m1.containsKey(s2.charAt(i)) || m1.get(s2.charAt(i)) == 0) return false;
                else m1.put(s2.charAt(i), m1.get(s2.charAt(i)) - 1);
            }
            else {
                if (!m2.containsKey(s2.charAt(i)) || m2.get(s2.charAt(i)) == 0) return false;
                else m2.put(s2.charAt(i), m2.get(s2.charAt(i)) - 1);
            }
        }

        return true;
    }
}
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> m = new HashMap<>();

        for (char c : word.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);

        List<Integer> vals = m.values().stream().sorted(Comparator.reverseOrder()).toList();

        int res = 0;
        for (int i = 0; i < vals.size(); i++) {
            res += vals.get(i) * (i / 8 + 1);
        }

        return res;
    }
}
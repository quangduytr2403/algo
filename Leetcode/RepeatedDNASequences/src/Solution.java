import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        String t;
        for (int i = 0; i < s.length() - 9; i++) {
            t = s.substring(i, i + 10);
            if (set.contains(t)) {
                if (!res.contains(t)) res.add(t);
            } else set.add(t);
        }

        return res.stream().toList();
    }
}
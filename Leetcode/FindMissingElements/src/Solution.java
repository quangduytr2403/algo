import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            s.add(n);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!s.contains(i)) res.add(i);
        }

        return res;
    }
}
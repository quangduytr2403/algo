import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        List<Integer> l;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) m.put(nums[i], new ArrayList<>());
            l = m.get(nums[i]);
            l.add(i);
            if (l.size() > 2) res = Math.min(res, 2 * (l.getLast() - l.get(l.size() - 3)));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
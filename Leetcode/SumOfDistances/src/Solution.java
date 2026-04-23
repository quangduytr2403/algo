import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        long[] res = new long[nums.length];
        long sufSum, prevSum;
        int idx;

        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) m.put(nums[i], new ArrayList<>());
            m.get(nums[i]).add(i);
        }

        for (var l : m.values()) {
            sufSum = 0;
            prevSum = 0;
            for (int num : l) sufSum += num;
            for (int i = 0; i < l.size(); i++) {
                idx = l.get(i);
                res[idx] = sufSum - (long) idx * (l.size() - i) + (long) idx * i - prevSum;
                sufSum -= idx;
                prevSum += idx;
            }
        }

        return res;
    }
}
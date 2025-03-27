import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> m = new TreeMap<>();

        int maxAppear = 0;
        int dominant = 0;
        int t;
        for (Integer num : nums) {
            t = m.getOrDefault(num, 0) + 1;
            m.put(num, t);
            if (t > maxAppear) {
                maxAppear = t;
                dominant = num;
            }
        }

        int countDominant = 0;
        for (int i = 1; i <= nums.size() - 1; i++) {
            if (nums.get(i - 1) == dominant) countDominant++;
            if (countDominant * 2 > i && (maxAppear - countDominant) * 2 > nums.size() - i) return i - 1;
        }

        return -1;
    }
}
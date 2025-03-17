import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);
        for (var v : m.values()) if (v % 2 == 1) return false;
        return true;
    }
}
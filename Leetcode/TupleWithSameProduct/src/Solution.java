import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        int t;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                t = nums[i] * nums[j];
                if (m.containsKey(t)) m.put(t, m.get(t) + 1);
                else m.put(t, 1);
            }
        }

        for (Integer v : m.values()) {
            if (v > 1)  res += v * (v - 1) * 4;
        }

        return res;
    }
}
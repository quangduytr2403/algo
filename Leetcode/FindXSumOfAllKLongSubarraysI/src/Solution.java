import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int j = 0; j < k; j++) {
                m.put(nums[i + j], m.getOrDefault(nums[i + j], 0 ) + 1);
            }
            res[i] = m.entrySet()
                    .stream()
                    .map(e -> new int[]{e.getKey(), e.getValue()})
                    .sorted((e1, e2) -> e1[1] == e2[1] ? e2[0] - e1[0] : e2[1] - e1[1])
                    .limit(x)
                    .mapToInt(arr -> arr[0] * arr[1])
                    .sum();
        }

        return res;
    }
}

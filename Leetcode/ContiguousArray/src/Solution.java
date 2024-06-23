import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int res = 0;
        Map<Integer, Integer> maxIndex = new HashMap<>();
        sum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i + 1] = nums[i] == 0 ? -1 : 1;
            else sum[i + 1] = sum[i] + (nums[i] == 0 ? -1 : 1);
            maxIndex.put(sum[i + 1], i + 1);
        }

        for (int i = 0; i < sum.length; i++) {
            if(maxIndex.containsKey(sum[i])) {
                res = Math.max(res, maxIndex.get(sum[i]) - i);
            }
        }

        return res;
    }
}
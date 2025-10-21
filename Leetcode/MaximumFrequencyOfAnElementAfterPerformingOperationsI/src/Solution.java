import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int[] sum = new int[3 * 100000 + 2];
        int[] app = new int[100000 + 2];
        for (int num : nums) {
            sum[num - k + 100000]++;
            sum[num + k + 100000 + 1]--;
            app[num]++;
        }
        int res = 1;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = (i > 0 ? sum[i - 1] : 0) + sum[i];
            res = Math.max(res, Math.min(sum[i], numOperations + (i - 100000 >= 0 && i - 100000 <= 100000 ? app[i - 100000] : 0)));
        }
        return res;
    }
}
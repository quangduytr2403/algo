import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] inc = new int[nums.size()];
        int res = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (i < nums.size() - 1 && nums.get(i) < nums.get(i + 1)) inc[i] = inc[i + 1] + 1;
            else inc[i] = 1;
            res = Math.max(res, Math.max(inc[i] / 2, i + 2 * inc[i] - 1 < nums.size() ? Math.min(inc[i], inc[i + inc[i]]) : -1));
        }

        return res;
    }
}
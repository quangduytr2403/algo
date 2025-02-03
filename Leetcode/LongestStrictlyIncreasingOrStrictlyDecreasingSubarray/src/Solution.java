class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;

        for (int i = 0; i < n; i++) {
            int inc = i;

            while (inc + 1 < n) {
                if (nums[inc + 1] > nums[inc]) inc++;
                else break;
            }

            int desc = i;

            while (desc + 1 < n) {
                if (nums[desc + 1] < nums[desc]) desc++;
                else break;
            }

            res = Math.max(inc - i + 1, Math.max(res, desc - i + 1));
        }

        return res;
    }
}
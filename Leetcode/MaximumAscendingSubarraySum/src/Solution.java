class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int p;
        int sum;

        for (int i = 0; i < n; i++) {
            p = i;
            sum = nums[i];

            while (p + 1 < n) {
                if (nums[p] < nums[p + 1]) {
                    sum += nums[p + 1];
                    p++;
                } else break;
            }

            res = Math.max(res, sum);
        }

        return res;
    }
}
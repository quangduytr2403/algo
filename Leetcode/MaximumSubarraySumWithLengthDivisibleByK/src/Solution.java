class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] sum = new long[nums.length];
        long[] min = new long[k];
        long res = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum[i] += (i == 0 ? 0 : sum[i - 1]) + (long) nums[i];
            if (i < k - 1) {
                min[i] = sum[i];
                continue;
            }
            res = Math.max(res, sum[i] - min[i % k]);
            min[i % k] = Math.min(min[i % k], sum[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4));
    }
}
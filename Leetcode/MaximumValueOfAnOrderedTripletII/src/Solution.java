class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] maxSub = new int[nums.length];
        int[] max = new int[nums.length];
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            max[i] = Math.max(nums[i], i == 0 ? Integer.MIN_VALUE : max[i - 1]);
            maxSub[i] = i == 0 ? 0 : Math.max(maxSub[i - 1] , max[i - 1] - nums[i]);
        }

        for (int i = 2; i < nums.length; i++) {
            res = Math.max(res, (long) nums[i] * (long) (maxSub[i - 1]));
        }

        return res;
    }
}
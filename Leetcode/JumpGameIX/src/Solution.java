class Solution {
    public int[] maxValue(int[] nums) {
        int[] max = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max[i] = Math.max(nums[i], i > 0 ? max[i - 1] : 0);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (max[i] > min) res[i] = res[i + 1];
            else res[i]  = max[i];
            min = Math.min(min, nums[i]);
        }

        return res;
    }
}
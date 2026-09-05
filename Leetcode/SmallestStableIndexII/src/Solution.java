class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        for (int i = 0; i < nums.length; i++) max[i] = i == 0 ? nums[i] : Math.max(max[i - 1], nums[i]);
        for (int i = nums.length - 1; i >= 0; i--) min[i] = i == nums.length - 1 ? nums[i] : Math.min(min[i + 1], nums[i]);

        for (int i = 0; i < nums.length; i++) if (max[i] - min[i] <= k) return i;
        return -1;
    }
}
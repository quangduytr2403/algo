class Solution {
    public int countValidSelections(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = i > 0 ? left[i - 1] + nums[i - 1] : 0;
        }

        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = i < nums.length - 1 ? right[i + 1] + nums[i + 1] : 0;
            if (nums[i] == 0) {
                if (right[i] == left[i]) res += 2;
                else if (Math.abs(right[i] - left[i]) == 1) res += 1;
            }
        }

        return res;
    }
}
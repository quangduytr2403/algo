class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - count - 1; j++) nums[j] = nums[j + 1];
                nums[nums.length - count - 1] = 0;
                count++;
            }
        }
    }
}
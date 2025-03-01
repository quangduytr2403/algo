class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] res = new int[nums.length];
        int index = 0;
        int index0 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[index0] = 0;
                index0--;
            } else {
                res[index] = nums[i];
                index++;
            }
        }

        return res;
    }
}
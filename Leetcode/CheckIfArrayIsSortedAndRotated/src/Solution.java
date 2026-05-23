class Solution {
    public boolean check(int[] nums) {
        int idx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) return true;
        else if (idx == nums.length - 1) {
            return nums[nums.length - 1] <= nums[0];
        } else {
            for (int i = idx + 1; i < idx + nums.length; i++) {
                if (nums[i % nums.length] < nums[(i - 1) % nums.length]) return false;
            }
        }

        return true;
    }
}
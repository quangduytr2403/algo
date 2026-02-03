class Solution {
    public boolean isTrionic(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                boolean check = true;
                for (int k = 0; k < nums.length - 1; k++) {
                    if ((nums[k] >= nums[k + 1] && (k < i || k >= j)) || (nums[k] <= nums[k + 1] && k >= i && k < j)) {
                        check = false;
                        break;
                    }
                }
                if (check) return true;
            }
        }

        return false;
    }
}
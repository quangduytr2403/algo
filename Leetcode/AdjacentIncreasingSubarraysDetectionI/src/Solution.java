import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        boolean check;
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            check = true;
            for (int j = 0; j < k - 1; j++) {
                if (nums.get(i + j) >= nums.get(i + j + 1)) {
                    check = false;
                    break;
                }
            }
            if (!check) continue;
            for (int j = 0; j < k - 1; j++) {
                if (nums.get(i + j + k) >= nums.get(i + j + k + 1)) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }
}
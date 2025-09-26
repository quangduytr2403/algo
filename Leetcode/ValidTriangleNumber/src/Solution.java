import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = find(nums, i, j, j + 1, nums.length - 1);
                if (index != -1) res += (index - j);
            }
        }
        return res;
    }

    int find(int[] nums, int i, int j, int l, int r) {
        if (l >= r - 1) {
            for (int k = r; k >= l; k--) {
                if (nums[k] < nums[i] + nums[j]) return k;
            }
            return -1;
        }
        int m = (l + r) / 2;
        if (nums[m] >= nums[i] + nums[j]) return find(nums, i, j, l, m - 1);
        else return find(nums, i, j, m, r);
    }
}
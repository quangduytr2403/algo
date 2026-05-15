class Solution {
    public int findMin(int[] nums) {
        int last = nums[nums.length - 1];

        return find(0, nums.length - 1, nums, last);
    }

    int find(int l, int r, int[] nums, int last) {
        if (l >= r - 1) {
            return Math.min(nums[l], nums[r]);
        }

        int m = (l + r) / 2;
        if (nums[m] > last) return find(m + 1, r, nums, last);
        else return find(l, m, nums, last);
    }
}
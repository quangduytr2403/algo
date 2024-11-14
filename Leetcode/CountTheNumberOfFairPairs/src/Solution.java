import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int last = findLast(i + 1, nums.length - 1, nums, upper - nums[i]);
            int first = findFirst(i + 1, nums.length - 1, nums, lower - nums[i]);

            res += ((last == -1 || first == -1) ? 0 : last - first + 1);
        }

        return res;
    }

    public int findLast(int l, int r, int[] nums, int val) {
        if (l > r) return -1;

        if (l >= r - 1) {
            if (r < nums.length && nums[r] <= val) return r;
            else if (l < nums.length && nums[l] <= val) return l;
            else return -1;
        }

        int m = (l + r) / 2;
        if (nums[m] > val) return findLast(l, m - 1, nums, val);
        else return findLast(m, r, nums, val);
    }

    public int findFirst(int l, int r, int[] nums, int val) {
        if (l > r) return -1;

        if (l >= r - 1) {
            if (l < nums.length && nums[l] >= val) return l;
            else if (r < nums.length && nums[r] >= val) return r;
            else return -1;
        }

        int m = (l + r) / 2;
        if (nums[m] < val) return findFirst(m + 1, r, nums, val);
        else return findFirst(l, m, nums, val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countFairPairs(new int[]{0,0,0,0,0,0}, 0, 0));
    }
}
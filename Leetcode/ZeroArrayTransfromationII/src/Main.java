class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        return find(-1, queries.length - 1, queries, nums);
    }

    public int find(int l, int r, int[][] queries, int[] nums) {
        if (l >= r - 1) {
            for (int j = l; j <= r; j++) {
                if (check(j, queries, nums)) return j + 1;
            }

            return -1;
        }

        int m = (l + r) / 2;
        if (check(m, queries, nums)) return find(l, m, queries, nums);
        else return find(m + 1, r, queries, nums);
    }

    public boolean check(int index, int[][] queries, int[] nums) {
        if (index == -1) {
            for (int num : nums) if (num != 0) return false;
            return true;
        }
        int[] count = new int[nums.length + 1];

        for (int i = 0;  i <= index; i++) {
            int[] q = queries[i];
            count[q[0]] += q[2];
            count[q[1] + 1] -= q[2];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) count[i] += count[i - 1];
            if (nums[i] > count[i]) return false;
        }

        return true;
    }
}
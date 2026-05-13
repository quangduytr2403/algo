class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        // diff[i] = change of moves when target sum reaches i
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            /*
             * Initially every target needs 2 moves
             * Then reduce moves for ranges that can be done in 1 move
             * And reduce again for exact sum needing 0 moves
             */

            // 2 moves for all
            diff[2] += 2;

            // 1 move range [low, high]
            diff[low] -= 1;
            diff[high + 1] += 1;

            // 0 move at exact sum
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int cur = 0;

        for (int target = 2; target <= 2 * limit; target++) {
            cur += diff[target];
            res = Math.min(res, cur);
        }

        return res;
    }
}
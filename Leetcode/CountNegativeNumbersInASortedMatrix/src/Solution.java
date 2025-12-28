class Solution {
    public int countNegatives(int[][] grid) {
        int pt = grid[0].length - 1;
        int res = 0;

        for (int[] ints : grid) {
            while (pt >= 0 && ints[pt] < 0) {
                pt--;
            }

            res += (grid[0].length - pt - 1);
        }

        return res;
    }
}
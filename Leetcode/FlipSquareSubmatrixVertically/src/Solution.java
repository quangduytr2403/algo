class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int tmp;

        for (int i = 0; i <= (k % 2 == 0 ? k / 2 - 1 : k / 2); i++) {
            for (int j = 0; j < k; j++) {
                tmp = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
                grid[x + k - 1 - i][y + j] = tmp;
            }
        }

        return grid;
    }
}
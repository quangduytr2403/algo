class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] check = new boolean[grid.length * grid.length + 1];
        int a = 0;
        int b = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (check[grid[i][j]]) a = grid[i][j];
                check[grid[i][j]] = true;
            }
        }

        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                b = i;
                break;
            }
        }

        return new int[]{a, b};
    }
}
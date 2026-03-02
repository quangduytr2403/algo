class Solution {
    public int minSwaps(int[][] grid) {
        int[] z = new int[grid.length];
        int count, res = 0, idx;

        for (int i = 0; i < grid.length; i++) {
            count = 0;
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            z[i] = count;
        }

        for (int i = 0; i < grid.length; i++) {
            idx = -1;
            for (int j = i; j < grid.length; j++) {
                if (z[j] >= grid.length - 1 - i) {
                    res += j - i;
                    idx = j;
                    break;
                }
            }
            if (idx == -1) return -1;
            else {
                for (int j = idx; j > i; j--) z[j] = z[j - 1];
            }
        }

        return res;
    }
}
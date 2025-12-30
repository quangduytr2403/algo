class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        int sum1, sum2, sum3, sum4, sum5, sum6, sum7, sum8;

        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                boolean[] check = new boolean[10];
                boolean c = true;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (grid[i + k][j + l] > 9 || grid[i + k][j + l] < 1) {
                            c = false;
                            break;
                        }
                        if (check[grid[i + k][j + l]]) {
                            c = false;
                            break;
                        } else {
                            check[grid[i + k][j + l]] = true;
                        }
                    }

                    if (!c) break;
                }
                if (!c) continue;

                sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                if (sum2 != sum1) continue;
                sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                if (sum3 != sum1) continue;
                sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                if (sum4 != sum1) continue;
                sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                if (sum5 != sum1) continue;
                sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
                if (sum6 != sum1) continue;
                sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                if (sum7 != sum1) continue;
                sum8 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
                if (sum8 != sum1) continue;
                res++;
            }
        }

        return res;
    }
}
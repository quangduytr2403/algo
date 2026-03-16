import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSize = Math.min(m / 2, n / 2);
        int sum;
        Set<Integer> vals = new TreeSet<>();

        for (int k = 0; k <= maxSize; k++) {
            for (int i = k; i < n - k; i++) {
                for (int j = k; j < m - k; j++) {
                    if (k == 0) {
                        vals.add(grid[i][j]);
                        continue;
                    }
                    sum = 0;
                    for (int o = 1; o < k; o++) {
                        sum += (grid[i - o][j - k + o] + grid[i - o][j + k - o] + grid[i + o][j - k + o] + grid[i + o][j + k - o]);
                    }
                    sum += (grid[i - k][j] + grid[i + k][j] + grid[i][j - k] + grid[i][j + k]);
                    vals.add(sum);
                }
            }
        }

        List<Integer> l = vals.stream().toList().reversed();
        if (l.size() >= 3) {
            l = l.subList(0, 3);
        }
        return l.stream().mapToInt(i -> i).toArray();
    }
}
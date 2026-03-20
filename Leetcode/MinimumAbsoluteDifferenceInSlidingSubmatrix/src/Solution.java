import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        int min;
        List<Integer> list;

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                min = Integer.MAX_VALUE;
                list = new ArrayList<>();
                for (int l = 0; l < k; l++) {
                    for (int o = 0; o < k; o++) {
                        list.add(grid[i + l][j + o]);
                    }
                }
                list.sort(Comparator.comparingInt(item -> item));
                if (list.getFirst().equals(list.getLast())) min = 0;
                else {
                    for (int l = 0; l < list.size() - 1; l++) {
                        if (!list.get(l).equals(list.get(l + 1))) {
                            min = Math.min(min, Math.abs(list.get(l) - list.get(l + 1)));
                        }
                    }
                }
                res[i][j] = min;
            }
        }

        return res;
    }
}
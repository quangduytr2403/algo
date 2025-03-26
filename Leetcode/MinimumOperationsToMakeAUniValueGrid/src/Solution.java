import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> l = new ArrayList<>();
        for (int[] r : grid) {
            for (int c : r) {
                l.add(c);
            }
        }
        l.sort(Comparator.comparingInt(a -> a));

        int mod = grid[0][0] % x;

        int res = 0;
        for (int[] r : grid) {
            for (int c : r) {
                if (c % x != mod) return -1;
                res += Math.abs(c / x - l.get(l.size() / 2) / x);
            }
        }

        return res;
    }
}
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] v = new int[m][n];

        if (grid.get(0).get(0) == 1 && health == 1) return false;

        Queue<Integer[]> q = new ArrayDeque<>();

        q.add(new Integer[]{0, 0, health - grid.get(0).get(0)});

        while (!q.isEmpty()) {
            Integer[] t = q.poll();

            if (t[0] == m - 1 && t[1] == n - 1 && t[2] > 0) return true;

            if (t[0] > 0 && t[2] - grid.get(t[0] - 1).get(t[1]) > v[t[0] - 1][t[1]]) {
                v[t[0] - 1][t[1]] = t[2] - grid.get(t[0] - 1).get(t[1]);
                q.add(new Integer[]{t[0] - 1, t[1], v[t[0] - 1][t[1]]});
            }

            if (t[1] > 0 && t[2] - grid.get(t[0]).get(t[1] - 1) > v[t[0]][t[1] - 1]) {
                v[t[0]][t[1] - 1] = t[2] - grid.get(t[0]).get(t[1] - 1);
                q.add(new Integer[]{t[0], t[1] - 1, v[t[0]][t[1] - 1]});
            }

            if (t[0] < m - 1 && t[2] - grid.get(t[0] + 1).get(t[1]) > v[t[0] + 1][t[1]]) {
                v[t[0] + 1][t[1]] = t[2] - grid.get(t[0] + 1).get(t[1]);
                q.add(new Integer[]{t[0] + 1, t[1], v[t[0] + 1][t[1]]});
            }

            if (t[1] < n - 1 && t[2] - grid.get(t[0]).get(t[1] + 1) > v[t[0]][t[1] + 1]) {
                v[t[0]][t[1] + 1] = t[2] - grid.get(t[0]).get(t[1] + 1);
                q.add(new Integer[]{t[0], t[1] + 1, v[t[0]][t[1] + 1]});
            }
        }

        return false;
     }
}
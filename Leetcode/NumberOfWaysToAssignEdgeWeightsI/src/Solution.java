import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int max = Integer.MIN_VALUE;
    Map <Integer, List<Integer>> m = new HashMap<>();
    int n;
    boolean[] visited;

    public int assignEdgeWeights(int[][] edges) {
        n = edges.length + 1;
        visited = new boolean[n + 1];

        for (int[] e : edges) {
            if (!m.containsKey(e[0])) m.put(e[0], new ArrayList<>());
            if (!m.containsKey(e[1])) m.put(e[1], new ArrayList<>());
            m.get(e[0]).add(e[1]);
            m.get(e[1]).add(e[0]);
        }

        visited[1] = true;
        dfs(1, 0);

        int res = 1;

        for (int i = 1; i <= max - 1; i++) {
           res = (res * 2) % 1_000_000_007;
        }

        return res;
    }

    void dfs(int node, int num) {
        for (int i = 0; i < m.get(node).size(); i++) {
            if (!visited[m.get(node).get(i)]) {
                max = Math.max(max, num + 1);
                visited[m.get(node).get(i)] = true;
                dfs(m.get(node).get(i), num + 1);
            }
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[][] path = new boolean[n][n];
        boolean[] visit = new boolean[n];
        int res = 0;

        for (int[] edge : edges) {
            path[edge[0]][edge[1]] = true;
            path[edge[1]][edge[0]] = true;
        }

        for (int i = 0 ; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int[] t = dfs(i, visit, path);
                if ((t[0] * (t[0] - 1)) / 2 == t[1] / 2) res++;
                // System.out.println(i + " " + t[0] + " " + t[1]);
            }
        }

        return res;
    }

    public int[] dfs(int i, boolean[] visit, boolean[][] path) {
        int res = 1;
        int edge = 0;

        for (int j = 0; j < visit.length; j++) {
            if (path[i][j]) {
                edge++;
                if (!visit[j]) {
                    visit[j] = true;
                    int[] t = dfs(j, visit, path);
                    res += t[0];
                    edge += t[1];
                }
            }
        }

        return new int[]{res, edge};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
    }
}
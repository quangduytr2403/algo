class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] g = new char[m][n];
        for (int[] guard : guards) g[guard[0]][guard[1]] = 'g';
        for (int[] wall : walls) g[wall[0]][wall[1]] = 'w';

        int tm, tn;
        for (int[] guard : guards) {
            tm = guard[0] - 1;
            tn = guard[1];
            while (tm >= 0 && g[tm][tn] != 'g' && g[tm][tn] != 'w') {
                g[tm][tn] = 'c';
                tm--;
            }
            tm = guard[0] + 1;
            while (tm < m && g[tm][tn] != 'g' && g[tm][tn] != 'w') {
                g[tm][tn] = 'c';
                tm++;
            }
            tm = guard[0];
            tn = guard[1] - 1;
            while (tn >= 0 && g[tm][tn] != 'g' && g[tm][tn] != 'w') {
                g[tm][tn] = 'c';
                tn--;
            }
            tn = guard[1] + 1;
            while (tn < n && g[tm][tn] != 'g' && g[tm][tn] != 'w') {
                g[tm][tn] = 'c';
                tn++;
            }
        }

        int res = 0;
        for (char[] gr : g)
            for (char gc : gr)  if (gc != 'c' && gc != 'w' && gc != 'g') res++;

        return res;
    }
}
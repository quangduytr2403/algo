class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        int[] trustedCount = new int[n + 1];
        int res = -1;

        for (int i = 0; i < trust.length; i++) {
            trustCount[trust[i][0]]++;
            trustedCount[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedCount[i] == n - 1) {
                if (res != -1) {
                    return -1;
                }
                res = i;
            }
        }

        return res;
    }
}
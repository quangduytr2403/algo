class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int m = dictionary.length;

        int[][] dp = new int[n][m];
        int res = 51;

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = 51;
                for (int k = 0; k <= j; k++) {
                    String tmp = dictionary[k];
                    if (i >= tmp.length() - 1 && s.substring(i - tmp.length() + 1, i + 1).equals(tmp)) {
                        int prevIndex = i - tmp.length();
                        dp[i][j] = Math.min(dp[i][j], prevIndex == -1 ? 0 : dp[prevIndex][j]);
                    }
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
                dp[i][j] = Math.min(dp[i][j], (i == 0 ? 0 : dp[i - 1][j]) + 1);

                if (i == n -1) res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minExtraChar("msgaxldzkgi", new String[]{"ax","ms","hvb","w","z","ajc","ti","cn","x","j","gi","r","nj","f","xr","iuz","ya","gty","hgs","ug","mfv","bw","vr","oe","xv","jf","vy","q","qf","oo","iq","t","v","htx","g","gjp","dis","gt","gv","wu","vtx","cmo","wdl","b"}));
    }
}

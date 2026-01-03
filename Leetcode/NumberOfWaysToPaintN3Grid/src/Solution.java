import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> avail = new ArrayList<>();

    public int numOfWays(int n) {
        boolean[][] valid = new boolean[13][13];
        int[][] dp = new int[n][13];
        int MOD = 1_000_000_007, res = 0;
        gen(0, "");
        boolean check;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                check = true;
                for (int k = 0; k < 3; k++) {
                    if (avail.get(i).charAt(k) == avail.get(j).charAt(k)) {
                        check = false;
                        break;
                    }
                }
                valid[i][j] = check;
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == 0) dp[i][j] = 1;
                else {
                    for (int k = 0; k < 12; k++) {
                        if (valid[j][k]) dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
                if (i == n - 1) res = (res + dp[i][j]) % MOD;
            }
        }

        return res;
    }

    void gen(int index, String s) {
        if (index == 3) {
            if (s.charAt(0) != s.charAt(1) && s.charAt(1) != s.charAt(2)) avail.add(s);
            return;
        }
        gen(index + 1, s + "R");
        gen(index + 1, s + "Y");
        gen(index + 1, s + "G");
    }
}
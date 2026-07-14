class Solution {
    int MOD = 1000000007;
    int[][][] dp;
    int[] nums;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n + 1][201][201];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 200; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    int dfs(int idx, int g1, int g2) {
        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != -1) {
            return dp[idx][g1][g2];
        }

        long ans = dfs(idx + 1, g1, g2);

        int ng1 = g1 == 0 ? nums[idx] : gcd(g1, nums[idx]);
        ans += dfs(idx + 1, ng1, g2);

        int ng2 = g2 == 0 ? nums[idx] : gcd(g2, nums[idx]);
        ans += dfs(idx + 1, g1, ng2);

        dp[idx][g1][g2] = (int)(ans % MOD);
        return dp[idx][g1][g2];
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
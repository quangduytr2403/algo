import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[201][201];
        int res = Integer.MAX_VALUE;
        List<Integer> l;
        for (int i = 0; i < triangle.size(); i++) {
            l =triangle.get(i);
            for (int j = 0; j < l.size(); j ++) {
                if (i == 0 && j == 0) dp[i][j] = l.get(j);
                else dp[i][j] = Math.min(j < l.size() - 1 ? dp[i - 1][j] : Integer.MAX_VALUE, j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE) + l.get(j);
                if (i == triangle.size() - 1) res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
    }
}
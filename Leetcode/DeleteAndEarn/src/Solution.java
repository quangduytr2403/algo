import java.util.List;
import java.util.TreeMap;

class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for (int num : nums) {
            if (!t.containsKey(num)) t.put(num, 0);
            t.put(num, t.get(num) + 1);
        }
        int[][] dp = new int[t.size()][2];
        List<Integer> lKey= t.keySet().stream().toList();

        for (int i = 0; i < lKey.size(); i++) {
            int val = lKey.get(i);
            // 0 is get
            dp[i][0] = (i == 0  ? 0 : (lKey.get(i - 1) == val - 1 ? dp[i - 1][1] : Math.max(dp[i - 1][0], dp[i - 1][1]))) + t.get(val) * val;
            // 1 is not get
            dp[i][1] = i == 0 ? 0 : Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[lKey.size() - 1][0], dp[lKey.size() - 1][1]);
    }
}
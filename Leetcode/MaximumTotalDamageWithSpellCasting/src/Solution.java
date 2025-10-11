import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> m = new TreeMap<>();

        for (int p : power) {
            if (!m.containsKey(p)) m.put(p, 0);
            m.put(p, m.get(p) + 1);
        }

        List<int[]> l =  m.entrySet().stream().map(e -> new int[]{e.getKey(), e.getValue()}).toList();
        long[] dp = new long[m.size()];

        for (int i = 0; i < dp.length; i++) {
            if (i > 1 && l.get(i - 2)[0] >= l.get(i)[0] - 2) dp[i] = i > 2 ? dp[i - 3] : 0;
            else if (i > 0 && l.get(i - 1)[0] >= l.get(i)[0] - 2) dp[i] = i > 1 ? dp[i - 2] : 0;
            else dp[i] = i > 0 ? dp[i - 1] : 0;
            dp[i] += (long) l.get(i)[0] * l.get(i)[1];
            dp[i] = Math.max(dp[i], i > 0 ? dp[i - 1] : 0);
        }

        return dp[m.size() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTotalDamage(new int[]{5,9,2,10,2,7,10,9,3,8}));
    }
}
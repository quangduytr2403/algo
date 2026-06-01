import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {
            if (i - 1 < 0) res += cost[i];
            else res += (cost[i] + cost[i - 1]);
        }

        return res;
    }
}
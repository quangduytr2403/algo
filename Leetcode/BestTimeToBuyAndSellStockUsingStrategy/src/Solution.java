class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long[] s1 = new long[prices.length];
        long[] s2 = new long[prices.length];
        long sum;
        
        for (int i = 0; i < prices.length; i++) {
            s1[i] = (i > 0 ? s1[i - 1] : 0) + (long) prices[i] * strategy[i];
            s2[i] = (i > 0 ? s2[i - 1] : 0) + prices[i];
        }

        long res = s1[prices.length - 1];

        for (int i = 0; i <= prices.length - k; i++) {
            sum = (i > 0 ? s1[i - 1] : 0) + (s1[prices.length - 1] - s1[i + k - 1]) + (s2[i + k - 1] - s2[i + (k / 2) - 1]);
            res = Math.max(res, sum);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{4, 2, 8}, new int[]{-1, 0, 1}, 2));
    }
}
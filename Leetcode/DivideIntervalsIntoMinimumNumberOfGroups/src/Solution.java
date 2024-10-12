class Solution {
    public int minGroups(int[][] intervals) {
        int[] sum = new int[1000002];
        int res = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            sum[interval[0]]++;
            sum[interval[1] + 1]--;
        }

        for(int i = 1; i <= 1000000; i++) {
            sum[i] = sum[i - 1] + sum[i];
            res = Math.max(res, sum[i]);
        }

        return res;
    }
}
import java.util.Arrays;

class Solution {
    int[][] resTrace = new int[51][51];

    public int minScoreTriangulation(int[] values) {
        return calc(values, 0, values.length - 1);
    }

    int calc(int[] values, int l, int r) {
        if (values.length == 3) return values[0] * values[1] * values[2];
        else if (values.length < 3) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < values.length - 1; i++) {
            int first = resTrace[l][l + i] == 0 ? calc(Arrays.copyOfRange(values, 0, i + 1), l, l + i) : resTrace[l][l + i];
            int second = resTrace[l + i][r] == 0 ?  calc(Arrays.copyOfRange(values, i, values.length), l + i, r) : resTrace[l + i][r];
            res = Math.min(res, values[0] * values[values.length - 1] * values[i] + first + second);
        }
        resTrace[l][r] = res;
        return res;
    }
}
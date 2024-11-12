import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] res = new int[queries.length];
        int[] max = new int[items.length];
        Arrays.sort(items, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        for (int i = 0; i < items.length; i++) {
            if (i == 0) max[i] = items[i][1];
            else max[i] = Math.max(max[i - 1], items[i][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            int index = findIndex(items, queries[i], 0, items.length - 1, max);
            if (index != -1) res[i] = max[index];
        }

        return res;
    }

    public int findIndex(int[][] items, int q, int l, int r, int[] max) {
        if (l >= r - 1) {
            if (items[r][0] <= q) return r;
            else if (items[l][0] <= q) return l;
            else return -1;
        }
        int m = (l + r) / 2;
        if (items[m][0] > q) return findIndex(items, q, l, m - 1, max);
        else return findIndex(items, q, m, r, max);
    }
}
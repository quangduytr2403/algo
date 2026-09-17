class Solution {
    int[] pre;
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        pre = new int[n];
        int[] min = new int[n];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            pre[i] = (i == 0 ? 0 : pre[i - 1]) + arr[i];
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int idx = find(-1, i - 1, pre[i] - target);

            if (idx != -2) {
                if (idx != -1 && min[idx] != Integer.MAX_VALUE) res = Math.min(res, min[idx] + i - idx);
                min[i] = i - idx;
            }

            min[i] = Math.min(i == 0 ? Integer.MAX_VALUE : min[i - 1], min[i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int find(int l, int r, int v) {
        if (l >= r- 1) {
            for (int i = r; i >= l; i--) if ((i == -1 ? 0 : pre[i]) == v) return i;
            return -2;
        }

        int m = (l + r) / 2;
        if ((m == -1 ? 0 : pre[m]) > v) return find(l, m - 1, v);
        else return find(m, r, v);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6));
    }
}
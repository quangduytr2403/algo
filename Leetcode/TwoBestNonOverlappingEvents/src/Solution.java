import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (e1, e2) -> e1[1] == e2[1] ? e2[2] - e1[2] : e1[1] - e2[1]);
        int[][] max = new int[events.length][2];
        int res = Integer.MIN_VALUE;
        int val;

        for (int i = 0; i < events.length; i++) {
            max[i][0] = events[i][1];
            max[i][1] = Math.max(i > 0 ? max[i - 1][1] : 0, events[i][2]);
            val = find(max, 0, i - 1, events[i][0]);
            res = Math.max(res, (val == -1 ? 0 : val) + events[i][2]);
        }

        return res;
    }

    int find(int[][] max, int l, int r, int t) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (max[i][0] < t) return max[i][1];
            }

            return -1;
        }

        int m = (l + r) / 2;
        if (max[m][0] >= t) return find(max, l, m - 1, t);
        else return find(max, m, r, t);
    }
}
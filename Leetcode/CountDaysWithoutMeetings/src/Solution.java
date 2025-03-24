import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        int end = 0;

        for (int[] meeting : meetings) {
            if (meeting[1] > end) {
                if (end < meeting[0]) {
                    res += meeting[0] - end - 1;
                }
                end = meeting[1];
            }
        }

        if (end < days) res += days - end;

        return res;
    }
}
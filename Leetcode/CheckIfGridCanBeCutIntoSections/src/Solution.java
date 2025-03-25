import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> a[0] == b[0] ? b[2] - a[2] : a[0] - b[0]);

        int count = 0;
        int cur = - 1;
        for(int[] rectangle : rectangles) {
            if (rectangle[0] >= cur) {
                if (cur != -1) count ++;
                if (count == 2) return true;
            }

            cur = Math.max(cur, rectangle[2]);
        }

        Arrays.sort(rectangles, (a, b) -> a[1] == b[1] ? b[3] - a[3] : a[1] - b[1]);

        count = 0;
        cur = - 1;
        for(int[] rectangle : rectangles) {
            if (rectangle[1] >= cur) {
                if (cur != -1) count ++;
                if (count == 2) return true;
            }

            cur = Math.max(cur, rectangle[3]);
        }

        return false;
    }
}
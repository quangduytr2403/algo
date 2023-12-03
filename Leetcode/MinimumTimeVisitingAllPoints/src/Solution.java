public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int n = points.length;

        for (int i = 1; i < n; ++i) {
            int diffx = Math.abs(points[i][0] - points[i - 1][0]);
            int diffy = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.max(diffx, diffy);
        }
        return ans;
    }
}

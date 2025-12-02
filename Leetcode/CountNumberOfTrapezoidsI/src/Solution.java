import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int countTrapezoids(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int c = 0;
        long sum = 0;
        int m = 1000000007;
        long res = 0;

        for (int i = 0; i <= points.length; i++) {
            if (i == points.length || (i > 0 && points[i][1] != points[i - 1][1])) {
                if (c >= 2) {
                    res += (((((long) c * (c - 1)) / 2) % m) * sum) % m;
                    res %= m;
                    sum += ((long) c * (c - 1)) / 2;
                }
                c = 1;
            } else c++;
        }

        return (int) res;
    }
}
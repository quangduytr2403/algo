import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long t = mass;

        for (int a : asteroids) {
            if (a > t) return false;
            else t += a;
        }

        return true;
    }
}
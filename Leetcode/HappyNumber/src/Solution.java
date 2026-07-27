import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        while (true) {
            n = sumSquare(n);
            if (n == 1) return true;
            if (s.contains(n)) return false;
            s.add(n);
        }
    }

    int sumSquare(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }

        return res;
    }
}
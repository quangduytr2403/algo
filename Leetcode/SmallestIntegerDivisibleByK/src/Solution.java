import java.util.HashSet;
import java.util.Set;

class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> s = new HashSet<>();
        int m = 0;
        int res = 0;

         do {
            m = (m * 10 + 1) % k;
            if (s.contains(m)) break;
            s.add(m);
            res++;
            if (m == 0) return res;
        } while (true);

        return -1;
    }
}
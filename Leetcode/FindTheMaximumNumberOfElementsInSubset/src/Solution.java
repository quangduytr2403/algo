import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {

        // Frequency of every number
        Map<Long, Integer> map = new HashMap<>();

        int ans = 0;

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);

            // Count 1's separately
            if (num == 1) ans++;
        }

        // Chain of only 1's must have odd length
        if (ans != 0 && ans % 2 == 0)
            ans--;

        for (long s : map.keySet()) { //each key only once computed

            if (s == 1) continue;

            int x = 0;
            long reqd = s;

            // Build chain: s -> s² -> s⁴ -> ...
            while (map.containsKey(reqd)) {

                // Need at least 2 copies to continue
                if (map.get(reqd) > 1) {
                    x += 2;
                    reqd *= reqd;
                } else {
                    // Last element needs only one copy
                    x++;
                    break;
                }
            }

            // Make chain length odd
            if (x != 0 && x % 2 == 0)
                x--;

            ans = Math.max(ans, x);
        }

        return ans == 0 ? 1 : ans;
    }
}
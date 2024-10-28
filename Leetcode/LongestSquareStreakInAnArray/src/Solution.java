import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> s = new HashSet<>();
        for (int num : nums) s.add((long)num);
        int res = -1;

        for (int num : nums) {
            long square = num;
            int length = 0;

            while (square < 100001) {
                if (s.contains(square)) {
                    length++;
                    square = square * square;
                } else {
                    break;
                }
            }

            if (length > 1) res = Math.max(res, length);
        }

        return res;
    }
}
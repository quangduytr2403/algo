import java.sql.Array;
import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> m = new HashMap<>();

        for (int[] rs : reservedSeats) {
            if (!m.containsKey(rs[0])) m.put(rs[0], new ArrayList<>());
            m.get(rs[0]).add(rs[1]);
        }

        int res = 0, count = 0;

        for (var v : m.values()) {
            count++;
            if (v.stream().noneMatch(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9)::contains)) res += 2;
            else if (
                v.stream().noneMatch(Arrays.asList(2, 3, 4, 5)::contains)
                || v.stream().noneMatch(Arrays.asList(4, 5, 6, 7)::contains)
                || v.stream().noneMatch(Arrays.asList(6, 7, 8, 9)::contains)
            ) res++;
        }

        return res + 2 * (n - count);
    }
}
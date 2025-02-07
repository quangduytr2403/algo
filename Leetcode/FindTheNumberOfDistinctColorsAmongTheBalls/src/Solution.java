import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> c = new HashMap<>();
        int oldColor;

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (m.containsKey(query[0])) {
                oldColor = m.get(query[0]);
                if (c.get(oldColor) == 1) c.remove(oldColor);
                else c.put(oldColor, c.get(oldColor) - 1);
            }
            c.put(query[1], (c.getOrDefault(query[1], 0)) + 1);
            m.put(query[0], query[1]);
            res[i] = c.size();
        }

        return res;
    }
}
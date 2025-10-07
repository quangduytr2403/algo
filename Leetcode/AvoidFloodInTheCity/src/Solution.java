import java.util.*;

class Solution {
    List<Integer> dry = new ArrayList<>();
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[rains.length];
        int rain;
        int idx;

        for (int i = 0; i < rains.length; i++) {
            rain = rains[i];
            if (rain == 0) {
                res[i] = 1;
                dry.add(i);
            }
            else {
                res[i] = -1;
                if (m.containsKey(rain)) {
                    idx = find(0, dry.size() - 1, m.get(rain), i);
                    if (idx == -1) return new int[0];
                    else res[idx] = rain;
                }
                m.put(rain, i);
            }
        }

        return res;
    }

    int find(int l, int r, int leftIdx, int rightIdx) {
        if (l >= r - 1) {
            for (int i = l; i <= r; i++) {
                if (dry.get(i) > leftIdx && dry.get(i) < rightIdx) {
                    return dry.remove(i);
                }
            }
            return -1;
        }

        int m = (l + r) / 2;
        if (dry.get(m) > leftIdx && dry.get(m) < rightIdx) return find(l, m, leftIdx, rightIdx);
        else return find(m + 1, r, leftIdx, rightIdx);
    }
}
import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> m = new TreeMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        int res = 1;

        for (int num : nums) {
            m.put(num - k, m.getOrDefault(num - k, 0) + 1);
            m.put(num + k + 1, m.getOrDefault(num + k + 1, 0) - 1);
            m2.put(num, m2.getOrDefault(num, 0) + 1);
        }

        List<Integer> key = m.keySet().stream().toList();
        List<Integer> val = m.values().stream().toList();
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < val.size(); i++) {
            sum.add((i == 0 ? 0 : sum.get(i - 1)) + val.get(i));
        }

        for (int num : nums) {
            int idx = findIdx(0, key.size() - 1, num, key);
            res = Math.max(res, Math.min(sum.get(idx), m2.getOrDefault(num, 0) + numOperations));
            idx = findIdx(0, key.size() - 1, num + k, key);
            res = Math.max(res, Math.min(sum.get(idx), m2.getOrDefault(num + k, 0) + numOperations));
            idx = findIdx(0, key.size() - 1, num - k, key);
            res = Math.max(res, Math.min(sum.get(idx), m2.getOrDefault(num - k, 0) + numOperations));
        }

        return res;
    }

    int findIdx(int l, int r, int num, List<Integer> key) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (key.get(i) <= num) return i;
            }
            return -1;
        }
        int m = (l + r) / 2;
        if (key.get(m) <= num) return findIdx(m, r, num, key);
        else return findIdx(l, m - 1, num, key);
    }
}
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!m.containsKey(arr[i])) {
                m.put(arr[i], 1);
            } else {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
        }

        List<Integer> l = new java.util.ArrayList<>(m.values().stream().toList());
        l.sort(Comparator.comparingInt(a -> a));
        int i = 0;
        while (i < l.size()) {
            if (k - l.get(i) >= 0) {
                k -= l.get(i);
                i++;
            } else {
                break;
            }
        }

        return l.size() - i;
    }
}
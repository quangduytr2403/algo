import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        List<Integer> l;
        int prev, aft;

        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) m.put(nums[i], new ArrayList<>());
            m.get(nums[i]).add(i);
        }

        for (int q : queries) {
            l = m.get(nums[q]);
            if (l.size() == 1) {
                res.add(-1);
                continue;
            }

            int idx = find(0, l.size() - 1, q, l);

            if (idx == 0) {
                prev = l.size() - 1;
                aft = 1;
            } else if (idx == l.size() - 1) {
                prev = l.size() - 2;
                aft = 0;
            } else {
                prev = idx - 1;
                aft = idx + 1;
            }

            res.add(Math.min(Math.abs(l.get(aft) - l.get(idx)), Math.min(nums.length - Math.abs(l.get(aft) - l.get(idx)), Math.min(Math.abs(l.get(idx) - l.get(prev)), nums.length - Math.abs(l.get(idx) - l.get(prev))))));
        }
        return res;
    }

    int find(int l, int r, int val, List<Integer> list) {
        if (l >= r - 1) {
            for (int i = l; i <= r; i++) {
                if (i < list.size() && list.get(i) == val) return i;
            }
            return -1;
        }

        int m = (l + r) / 2;
        if (list.get(m) >= val) return find(l, m, val, list);
        else return find(m + 1, r, val, list);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveQueries(new int[]{1,3,1,4,1,3,2},  new int[]{0,3,5}));
    }
}
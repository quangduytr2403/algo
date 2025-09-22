import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Long> s = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] check = new boolean[nums.length];

        gen(nums, check, 0);
        return res;
    }

    void gen(int[] nums, boolean[] check, int index) {
        if (index == check.length) {
           List<Integer> l = new ArrayList<>();
           for (int i = 0; i < check.length; i++) if (check[i]) l.add(nums[i]);
           if (!checkDup(l)) res.add(l);
           return;
        }
        check[index] = true;
        gen(nums, check, index + 1);
        check[index] = false;
        gen(nums, check, index + 1);
    }

    boolean checkDup(List<Integer> l) {
        l.sort(Comparator.comparingInt(l2 -> l2));
        long code = 0;
        for (int i = 0; i < l.size(); i++) {
            code += (long) ((l.get(i) + 11) * Math.pow(21, i));
        }

        if (s.contains(code)) return true;
        else {
            s.add(code);
            return false;
        }
    }
}
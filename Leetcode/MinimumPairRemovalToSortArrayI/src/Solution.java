import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        int res = 0, min, idx = 0;
        boolean check;

        while (true) {
            check = true;
            min = Integer.MAX_VALUE;

            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i + 1) < l.get(i)) {
                    check = false;
                }
                if (l.get(i + 1) + l.get(i) < min) {
                    min = l.get(i + 1) + l.get(i);
                    idx = i;
                }
            }
            if (check) break;
            else res++;

            l.remove(idx);
            l.remove(idx);
            l.add(idx, min);
        }

        return res;
    }
}
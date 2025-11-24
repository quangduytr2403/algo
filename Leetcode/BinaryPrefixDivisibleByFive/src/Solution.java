import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int m = 0;
        for (int num : nums) {
            m = (m * 2 + num) % 5;
            if (m == 0) res.add(true);
            else res.add(false);
        }

        return res;
    }
}
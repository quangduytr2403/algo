import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        List<Integer> l = new ArrayList<>();
        l.add(1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (l.size() == sum + 1) l.set(sum, l.get(sum) + 1);
            else l.add(1);
        }

        int res = 0;
        if (goal == 0) {
            for(int i = 0; i < l.size(); i++) res += l.get(i) * (l.get(i) - 1) / 2;
        } else {
            for(int i = 0; i < l.size(); i++) {
                if (i + goal < l.size()) res += l.get(i) * l.get(i + goal);
            }
        }

        return res;
    }
}
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int n : nums) s.add(n);

        int sum = 0, count = 0;

        while (true) {
            if (count < nums.length && (count == 0 || nums[count] - nums[count - 1] == 1)) {
                sum += nums[count];
            } else break;
            count++;
        }

        while (true) {
            if (!s.contains(sum)) return sum;
            sum++;
        }
    }
}
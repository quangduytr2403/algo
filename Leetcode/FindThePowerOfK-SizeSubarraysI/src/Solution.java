import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            if (k == 1) {
                res.add(nums[i]);
                continue;
            }
            for (int j = 1; j < k; j++) {
                if (nums[i + j] == nums[i + j - 1] + 1) {
                    if (j == k -1) {
                        res.add(nums[i + j]);
                    }
                } else {
                    res.add(-1);
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
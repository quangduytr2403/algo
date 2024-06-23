import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int maxIndex = 0;
        int maxLength = 1;

        Arrays.sort(nums);
        int[][] t = new int[nums.length][2]; //0-max length, 1-previous index
        for (int i = 0; i < nums.length; i++) {
            t[i][0] = 1;
            t[i][1] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[j][0] + 1 > t[i][0]) {
                        t[i][0] = t[j][0] + 1;
                        t[i][1] = j;
                    }
                }
            }

            if (t[i][0] > maxLength) {
                maxLength = t[i][0];
                maxIndex = i;
            }
        }

        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = t[maxIndex][1];
        }

        return res;
    }
}

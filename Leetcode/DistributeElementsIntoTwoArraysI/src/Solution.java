import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) a1.add(nums[i]);
            else if (i == 1) a2.add(nums[i]);
            else if (a1.getLast() > a2.getLast())  a1.add(nums[i]);
            else a2.add(nums[i]);
        }
        a1.addAll(a2);
        return a1.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();
        List<Integer> after = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) prev.add(num);
            else if (num > pivot) after.add(num);
            else eq.add(num);
        }

        prev.addAll(eq);
        prev.addAll(after);

        return prev.stream().mapToInt(Integer::intValue).toArray();
    }
}
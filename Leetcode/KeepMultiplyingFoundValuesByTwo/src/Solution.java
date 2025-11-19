import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        while (s.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        int count = 1;
        while (true) {
            int finalCount = count;
            if (IntStream.of(nums).noneMatch(x -> x == (k * finalCount))) return k * count;
            count++;
        }
    }
}
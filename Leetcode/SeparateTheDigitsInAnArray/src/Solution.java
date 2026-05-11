import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            char[] cA = Integer.toString(n).toCharArray();
            for (char c : cA) res.add(c - '0');
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
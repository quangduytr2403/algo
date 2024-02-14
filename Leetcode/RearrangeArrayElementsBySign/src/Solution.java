import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();

        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!positive.isEmpty() && !negative.isEmpty()) {
            res.add(positive.poll());
            res.add(negative.poll());
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
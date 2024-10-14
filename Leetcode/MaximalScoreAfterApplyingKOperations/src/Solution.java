import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) p.add(num);

        long res = 0;

        while (k > 0) {
            int num = p.poll();
            res += num;
            p.add((int) Math.ceil((double)num / 3));
            k--;
        }

        return res;
    }
}
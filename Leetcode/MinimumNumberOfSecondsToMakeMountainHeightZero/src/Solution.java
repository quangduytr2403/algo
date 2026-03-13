import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long res = 0;
        PriorityQueue<Long[]> p = new PriorityQueue<>(Comparator.comparingLong(x -> x[1] + x[0]));

        for (int w : workerTimes) p.add(new Long[]{(long) w, 0L, 1L});

        while (mountainHeight > 0) {
            Long[] tmp = p.poll();
            res = Math.max(res, tmp[1] + tmp[0]);
            p.add(new Long[]{tmp[0] / tmp[2] * (tmp[2] + 1), tmp[1] + tmp[0], tmp[2] + 1});
            mountainHeight--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfSeconds(5, new int[]{1, 7}));
    }
}
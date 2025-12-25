import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int h : happiness) q.add(h);
        int c = 0;
        long res = 0;

        while (k > 0) {
            res += Math.max(q.poll() - c, 0);
            c++;
            k--;
        }

        return res;
    }
}
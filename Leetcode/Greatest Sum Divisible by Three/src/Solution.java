import java.util.PriorityQueue;

class Solution {
    public int maxSumDivThree(int[] nums) {
        PriorityQueue<Integer> m1 = new PriorityQueue<>();
        PriorityQueue<Integer> m2 = new PriorityQueue<>();
        int sum = 0;
        int res= 0;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) m1.add(num);
            else if (num % 3 == 2) m2.add(num);
        }

        if (sum % 3 == 1) {
            if (!m1.isEmpty()) {
                res = sum - m1.poll();
            }
            if (m2.size() > 1) {
                res = Math.max(res, sum - m2.poll() - m2.poll());
            }

            return res;
        } else if (sum % 3 == 2) {
            if (!m2.isEmpty()) {
                res = sum - m2.poll();
            }
            if (m1.size() > 1) {
                res = Math.max(res, sum - m1.poll() - m1.poll());
            }

            return res;
        }

        return sum;
    }
}
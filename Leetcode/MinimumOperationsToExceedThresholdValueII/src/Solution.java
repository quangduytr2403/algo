import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Long> p = new PriorityQueue<>();

        for (int num : nums) p.add((long) num);

        while (p.peek() < k) {
            p.add(2 * p.poll() + p.poll());
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
    }
}
import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        long[] prefixGcd = new long[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            res += gcd(prefixGcd[i], prefixGcd[nums.length - 1 - i]);
        }

        return res;
    }

    long gcd (long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
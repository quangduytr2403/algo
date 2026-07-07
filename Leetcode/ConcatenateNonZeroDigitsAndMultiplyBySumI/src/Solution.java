class Solution {
    public long sumAndMultiply(int n) {
        String x = "";
        long sum = 0;
        int t;
        while (n > 0) {
            t= n % 10;
            if (t != 0) {
                x = t + x;
                sum += t;
            }
            n = n / 10;
        }

        if (x.isEmpty()) return 0;
        return Integer.valueOf(x) * sum;
    }
}
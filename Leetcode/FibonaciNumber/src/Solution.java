class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int p1 = 0, p2 = 1, t;

        while (n > 1) {
            t = p2;
            p2 = p1 + p2;
            p1 = t;
            n--;
        }

        return p2;
    }
}
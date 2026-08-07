class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (prod(n) % t == 0) return n;
            n++;
        }
    }

    int prod(int a) {
        int res = 1;
        while (a > 0) {
            res *= a % 10;
            a /= 10;
        }
        return res;
    }
}
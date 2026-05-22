class Solution {
    public int mySqrt(int x) {
        return find(0, x, x);
    }

    int find(long l, long r, long x) {
        if (l >= r - 2) {
            for (long i = r; i >= l; i--) {
                if (i * i <= x) return (int) i;
            }

            return -1;
        }

        long m = l / 2  + r / 2;
        if (m * m == x) return(int) m;
        else if (m * m < x) return find(m, r, x);
        else return find(l, m - 1, x);
    }
}
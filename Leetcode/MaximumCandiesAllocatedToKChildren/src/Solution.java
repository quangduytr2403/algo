class Solution {
    public int maximumCandies(int[] candies, long k) {
        return find(1, 10000000, candies, k);
    }

    public int find(int l, int r, int[] candies, long k) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (check(i, candies, k)) return i;
            }
            return 0;
        }

        int m = (l + r) / 2;
        if (check(m, candies, k)) return find(m, r, candies, k);
        else return find(l, m - 1, candies, k);
    }

    public boolean check(int num, int[] candies, long k) {
        for (int candy : candies) {
            k -= candy / num;
            if (k <= 0) return true;
        }

        return false;
    }
}
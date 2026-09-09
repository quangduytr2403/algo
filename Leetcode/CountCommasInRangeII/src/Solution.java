class Solution {
    public long countCommas(long n) {
        long res = 0;
        if (n <= 999) return 0;

        if (n <= 999_999) return res + n - 999;
        else res += 999_999 - 999;

        if (n <= 999_999_999L) return res + 2 * (n - 999_999);
        else res += 2 * (999_999_999L - 999_999);

        if (n <= 999_999_999_999L) return res + 3 * (n - 999_999_999L);
        else res += 3 * (999_999_999_999L - 999_999_999L);

        if (n <= 999_999_999_999_999L) return res + 4 * (n - 999_999_999_999L);
        else res += 4 * (999_999_999_999_999L - 999_999_999_999L) + 5;

        return res;
    }
}
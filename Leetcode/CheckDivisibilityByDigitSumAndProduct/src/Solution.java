class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, prod = 1, N = n;

        while (n > 0) {
            sum += n % 10;
            prod *= n % 10;
            n /= 10;
        }

        return N % (sum + prod) == 0;
    }
}
class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        n--;

        long[][] U = new long[m][m];
        long[][] D = new long[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) U[i][j] = 1;
            for (int j = i + 1; j < m; j++) D[i][j] = 1;
        }

        long[][] UD = multiply(U, D);

        long[][] V = power(UD, n / 2);

        if ((n & 1) == 1) {
            V = multiply(V, U);
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans = (ans + V[i][j]) % MOD;
            }
        }

        ans = (ans * 2) % MOD;
        return (int) ans;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                long x = A[i][k];
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + x * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] power(long[][] A, int e) {
        int n = A.length;
        long[][] R = new long[n][n];

        for (int i = 0; i < n; i++) R[i][i] = 1;

        while (e > 0) {
            if ((e & 1) == 1) R = multiply(R, A);
            A = multiply(A, A);
            e >>= 1;
        }
        return R;
    }
}
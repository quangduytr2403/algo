class Solution {
    public boolean checkPowersOfThree(int n) {
        double s = Math.log(n) / Math.log(3);

        boolean[] a = new boolean[(int) s + 1];
        return gen(a, (int) s + 1, n, 0);
    }

    public boolean gen(boolean[] a, int s, int n, int idx) {
        if (idx == s) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) if (a[i]) sum += (int) Math.pow(3, i);
            return sum == n;
        }

        boolean t = gen(a, s, n, idx + 1);
        if (t) return t;

        a[idx] = true;
        t = gen(a, s, n, idx + 1);
        if (t) return t;
        a[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(12));
    }
}
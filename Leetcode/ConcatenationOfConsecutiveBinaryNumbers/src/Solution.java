class Solution {
    public int concatenatedBinary(int n) {
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            res = Math.toIntExact((((long) ((long) res * Math.pow(2, Integer.toBinaryString(i).length())) % 1_000_000_007 + i)) % 1_000_000_007);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().concatenatedBinary(10));
    }
}
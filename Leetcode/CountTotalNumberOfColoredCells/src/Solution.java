class Solution {
    public long coloredCells(int n) {
//        long res = 1;
//
//        for (int i = 1; i <= n; i ++) {
//            res += 4L * (i - 1);
//        }

        return 2L * (n -1) * n + 1;
    }
}
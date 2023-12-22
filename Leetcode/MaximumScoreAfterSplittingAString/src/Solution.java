class Solution {
    public int maxScore(String s) {
        int oneCount = (int) s.chars().filter(ch -> ch == '1').count();
        int res = 0;
        int zeroCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                oneCount--;
            } else {
                zeroCount++;
            }
            res = Math.max(res, zeroCount + oneCount);
        }
        return res;
    }
}
class Solution {
    public int countBinarySubstrings(String s) {
        s = s + "2";

        int prev = 0, curr = 0, res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            curr++;
            if (s.charAt(i) != s.charAt(i + 1)) {
                res += Math.min(prev, curr);
                prev = curr;
                curr = 0;
            }
        }

        return res;
    }
}
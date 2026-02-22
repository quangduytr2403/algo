class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);

        int res = 0;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (prev != -1) res = Math.max(i - prev, res);
                prev = i;
            }
        }

        return res;
    }
}
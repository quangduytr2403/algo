class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        String s = "0";

        for (int i = 2; i <= n; i++) {
            char c = s.charAt(s.length() / 2);
            if (c == '0') c = '1';
            else c = '0';
            s += '1' + s.substring(0, s.length() / 2) + c + s.substring(s.length() / 2 + 1);
        }

        return s.charAt(k - 1);
    }
}
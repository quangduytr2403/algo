class Solution {
    public void reverseString(char[] s) {
        char t;
        int n = s.length;
        for (int i = 0; i <= (n % 2 == 0 ? n / 2 - 1 : n / 2); i++) {
            t = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = t;
        }
    }
}
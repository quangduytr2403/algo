class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder t;
        while (s.length() > 2) {
            t = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                t.append((char)((((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10) + (int)'0'));
            }
            s = t.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}
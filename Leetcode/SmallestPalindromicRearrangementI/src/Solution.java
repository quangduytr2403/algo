import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;

        char[] charStr = s.substring(0, n / 2).toCharArray();
        Arrays.sort(charStr);
        StringBuilder sb = new StringBuilder();
        for (char c : charStr) sb.append(c);
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();

        if (n % 2 == 0) return sb + sb2.toString();
        else return sb.toString() + s.charAt(n / 2) + sb2;
    }
}
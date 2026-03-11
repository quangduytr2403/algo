class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String s2 = "";
        for (char c : s.toCharArray()) {
            if (c == '0') s2 += "1";
            else s2 += "0";
        }
        return Integer.parseInt(s2, 2);
    }
}
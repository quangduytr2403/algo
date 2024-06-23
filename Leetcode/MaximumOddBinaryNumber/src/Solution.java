class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') sb.insert(0, '1');
            else sb.append('0');
        }
        return sb.substring(1) + '1';
    }
}
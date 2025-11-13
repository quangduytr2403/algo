class Solution {
    public int maxOperations(String s) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (i < s.length() - 1 && s.charAt(i + 1) == '0') res += count;
            }
        }

        return res;
    }
}
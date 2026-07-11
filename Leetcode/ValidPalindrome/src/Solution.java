class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sb.append(("" + c).toLowerCase());
        }

        String sr = new StringBuilder(sb).reverse().toString();
        return sb.toString().equals(sr);
    }
}
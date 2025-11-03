class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int idx = s.lastIndexOf(' ');
        return idx >= 0 ? s.substring(idx + 1).length() : s.length();
    }
}
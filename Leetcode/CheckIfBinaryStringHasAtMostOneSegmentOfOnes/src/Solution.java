class Solution {
    public boolean checkOnesSegment(String s) {
        boolean z = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') z = true;
            else if (z) return false;
        }

        return true;
    }
}
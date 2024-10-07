class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            int index = s.indexOf("AB");
            if (index < 0) index = s.indexOf("CD");
            s = s.substring(0, index) + s.substring(index + 2);
        }
        return s.length();
    }
}
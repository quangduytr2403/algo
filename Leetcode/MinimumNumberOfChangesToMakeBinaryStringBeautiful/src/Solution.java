class Solution {
    public int minChanges(String s) {
        int res = 0;
        int index = 0;

        while (index < s.length()) {
            if (s.charAt(index) != s.charAt(index + 1)) res++;
            index += 2;
        }

        return res;
    }
}
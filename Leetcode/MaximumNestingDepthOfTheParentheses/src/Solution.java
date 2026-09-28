class Solution {
    public int maxDepth(String s) {
        int max = 0, cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cur++;
                max = Math.max(max, cur);
            } else if (c == ')') {
                cur--;
            }
        }

        return max;
    }
}
class Solution {
    public int countSubstrings(String s) {
        boolean[][] pl = new boolean[s.length()][s.length()];
        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || j - i == 1 || pl[i + 1][j - 1]) {
                        pl[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
class Solution {
    public int totalWaviness(int num1, int num2) {
        String s;
        int res = 0;
        for (int i = num1; i <= num2; i++) {
            s = Integer.toString(i);
            for (int j = 1; j < s.length() - 1; j++) {
                if ((s.charAt(j) > s.charAt(j - 1) && s.charAt(j) > s.charAt(j + 1))
                        || (s.charAt(j) < s.charAt(j - 1) && s.charAt(j) < s.charAt(j + 1))) {
                    res++;
                }
            }
        }

        return res;
    }
}
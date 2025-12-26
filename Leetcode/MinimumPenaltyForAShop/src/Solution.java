class Solution {
    public int bestClosingTime(String customers) {
        int sumY = 0;
        int[][] s = new int[customers.length()][2];

        for (int i = 0; i < customers.length(); i++) {
            s[i][0] = i > 0 ? s[i - 1][0] : 0;
            s[i][1] = i > 0 ? s[i - 1][1] : 0;
            if (customers.charAt(i) == 'Y') {
                s[i][0]++;
                sumY++;
            }
            else s[i][1]++;
        }

        int min = Integer.MAX_VALUE, res = -1, pen;
        for (int i = 0; i <= customers.length(); i++) {
            pen = (i > 0 ? s[i-1][1] : 0) + (sumY - (i > 0 ? s[i-1][0] : 0));
            if (pen < min) {
                min = pen;
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bestClosingTime("NNNYNN"));
    }
}
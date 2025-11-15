import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfSubstrings(String s) {
        int[][] c = new int[s.length()][2];
        List<Integer> z = new ArrayList<>();
        int res = 0;
        int num0, num1, diff;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                z.add(i);
                c[i][0] = i > 0 ? c[i - 1][0] + 1 : 1;
                c[i][1] = i > 0 ? c[i - 1][1] : 0;
            } else {
                c[i][0] = i > 0 ? c[i - 1][0] : 0;
                c[i][1] = i > 0 ? c[i - 1][1] + 1 : 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!z.isEmpty()) {
                res += z.get(0) - i;
                for (int j = 0; j < Math.min(z.size(), (int) Math.sqrt(s.length())); j++) {
                    num0 = c[z.get(j)][0] - (i > 0 ? c[i - 1][0] : 0);
                    num1 =  c[z.get(j)][1] - (i > 0 ? c[i - 1][1] : 0);
                    diff = num1 - num0 * num0;
                    res += Math.max(0, (j == z.size() - 1 ? s.length() - z.get(j): z.get(j + 1) - z.get(j)) + (Math.min(diff, 0)));
                }

                if (z.get(0) <= i) z.remove(0);
            } else {
                res += s.length() - i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("101101"));
    }
}
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int res = Integer.MIN_VALUE;

    public int maxUniqueSplit(String s) {
        int[] c = new int[s.length()];
        gen(c, 0, s);

        return res;
    }

    public void gen(int[] c, int index, String s) {
        if (index == s.length() - 1) {
            c[index] = 1;
            int t = check(c, s);
            if (t > -1) res = Math.max(res, t);
            return;
        }

        c[index] = 0;
        gen(c, index + 1, s);

        c[index] = 1;
        gen(c, index + 1, s);
    }

    public int check(int[] c, String s) {
        int prevIndex = 0;
        Set<String> set = new HashSet<>();
        int countOne = 0;

        for(int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                countOne++;
                String tmp = s.substring(prevIndex, i + 1);
                if (set.contains(tmp)) return -1;
                else {
                    set.add(tmp);
                }
                prevIndex = i + 1;
            }
        }

        return countOne;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxUniqueSplit("aba"));
    }
}
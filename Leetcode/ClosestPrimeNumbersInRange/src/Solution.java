import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] mark = new boolean[right + 1];
        List<Integer> l = new ArrayList<>();
        for (int i = 2; i <= right; i++) {
            if (!mark[i] && i >= left) l.add(i);

            mark[i] = true;
            int num = 2 * i;
            while (num <= right) {
                mark[num] = true;
                num += i;
            }
        }

        if (l.size() < 2) return new int[]{-1, -1};
        else {
            int[] res = new int[]{-1, 99999999};

            for (int i = 1; i < l.size(); i++) {
                if (l.get(i) - l.get(i - 1) < res[1] - res[0]) {
                    res[1] = l.get(i);
                    res[0] = l.get(i - 1);
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().closestPrimes(10, 19)));
    }
}
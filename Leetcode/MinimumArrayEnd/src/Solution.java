import java.util.ArrayList;
import java.util.List;

class Solution {
    public long minEnd(int n, int x) {
        if (n == 1) return x;
        n--;
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(n);
        List<Integer> flipIndex = new ArrayList<>();
        int pointer1 = s1.length() - 1;
        int pointer2 = s2.length() - 1;

        while (pointer2 >= 0) {
            if (pointer1 < 0 || s1.charAt(pointer1) == '0'){
                if (s2.charAt(pointer2) == '1') flipIndex.add(s1.length() - 1 - pointer1);
                pointer2--;
            }

            pointer1--;
        }

        long res = x;
        for (int i : flipIndex) res += (long) Math.pow(2, i);

        return res;
    }
}
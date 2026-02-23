import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> token = new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
        char[] bt = new char[k];
        for (int i = 0; i <= s.length() - k; i++) token.add(s.substring(i, i + k));

        return gen(0, bt, s);
    }

    boolean gen(int idx, char[] bt, String s) {
        if (idx == bt.length) {
            return token.contains(new String(bt));
        }

        bt[idx] = '0';
        boolean check = gen(idx + 1, bt, s);
        if (!check) return false;

        bt[idx] = '1';
        return gen(idx + 1, bt, s);
    }
}
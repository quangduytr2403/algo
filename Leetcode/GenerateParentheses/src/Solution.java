import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        gen("", n, 2 * n, 0);
        return res;
    }

    void gen(String s, int N, int n, int openCount) {
        if (n == 0) {
            if (openCount == 0) res.add(s);
            return;
        }
        if (openCount > 0) gen(s +  ")", N, n - 1, openCount - 1);
        if (openCount < N) gen(s +  "(", N, n - 1, openCount + 1);
    }
}
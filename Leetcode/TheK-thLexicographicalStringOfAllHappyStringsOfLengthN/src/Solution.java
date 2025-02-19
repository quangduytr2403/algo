import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        gen(sb, res, n, 0);

        if (res.size() >= k) return res.get(k -1);
        else return "";
    }

    public void gen(StringBuilder sb, List<String> res, int n, int index) {
        if (index == n) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i <= 2; i++) {
            if (index == 0 || ((char) ((int)'a' + i) != sb.charAt(index - 1))) {
                sb.append((char) ((int) 'a' + i));
                gen(sb, res, n, index + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
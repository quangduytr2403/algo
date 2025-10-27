import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> l = new ArrayList<>();
        int o;
        for (String s : bank) {
            o = 0;
            for (int i = 0; i < s.length(); i++) if(s.charAt(i) == '1') o++;
            l.add(o);
        }
        int prev = -1;
        int res = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) > 0) {
                if (prev > 0) res += prev * l.get(i);
                prev = l.get(i);
            }
        }
        return res;
    }
}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> m = new HashMap<>();

        knowledge.forEach(l -> m.put(l.getFirst(), l.get(1)));

        StringBuilder sbRes = new StringBuilder(), t = new StringBuilder();
        boolean open = false;
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')') {
                if (open) t.append(c);
                else sbRes.append(c);
            }
            else {
                if (c == '(') {
                    t = new StringBuilder();
                    open = true;
                }
                else {
                    sbRes.append(m.getOrDefault(t.toString(), "?"));
                    open = false;
                }
            }
        }

        return sbRes.toString();
    }
}
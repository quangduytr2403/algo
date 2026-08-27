import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        Map<Character, Integer> m = new TreeMap<>();

        for (char c : s.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);

        char c;
        int idx = 0;
        String totalRes = "";

        for (int i = 0; i < target.length(); i++) {
            c = target.charAt(i);
            if (m.keySet().stream().toList().getLast() > c) {
                String res = target.substring(0, i);
                StringBuilder tsb = new StringBuilder();
                for (char k : m.keySet()) {
                    tsb.append((k + "").repeat(m.get(k)));
                }
                String t = tsb.toString();
                for (int j = 0; j < t.length(); j++) {
                    if (t.charAt(j) > c) {
                        idx = j;
                        break;
                    }
                }
                res += (t.charAt(idx) + t.substring(0, idx) + t.substring(idx + 1));
                if (totalRes.isEmpty() || res.compareTo(totalRes) < 0) totalRes = res;
            }
            if (m.containsKey(c)) {
                m.put(c, m.get(c) - 1);
                if (m.get(c) == 0) m.remove(c);
            } else break;
        }

        return totalRes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexGreaterPermutation("leet", "code"));
    }
}
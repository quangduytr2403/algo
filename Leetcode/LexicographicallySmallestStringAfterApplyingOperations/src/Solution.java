import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> st = new HashSet<>();
        String res = s;
        q.add(s);
        String t;
        String rotate;
        String add;

        while (!q.isEmpty()) {
            t = q.poll();
            add = add(t, a);
            res = res.compareTo(add) < 0 ? res : add;
            if (!st.contains(add)) q.add(add);
            st.add(add);

            rotate = rotate(t, b);
            res = res.compareTo(rotate) < 0 ? res : rotate;
            if (!st.contains(rotate)) q.add(rotate);
            st.add(rotate);
        }

        return res;
    }

    String add(String s, int a) {
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) r.append(s.charAt(i));
            else r.append((((s.charAt(i) - '0') + a) % 10));
        }

        return r.toString();
    }

    String rotate(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }
}
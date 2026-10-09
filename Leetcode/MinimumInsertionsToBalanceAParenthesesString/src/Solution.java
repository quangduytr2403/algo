import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int cur = 0;
        int res = 0;

        while (cur < s.length()) {
            if (s.charAt(cur) == '(') st.push('(');
            else {
                if (st.isEmpty()) res++;
                else st.pop();

                if (cur == s.length() - 1 || s.charAt(cur + 1) == '(') res++;
                else cur++;
            }
            cur++;
        }

        return res + st.size() * 2;
    }
}
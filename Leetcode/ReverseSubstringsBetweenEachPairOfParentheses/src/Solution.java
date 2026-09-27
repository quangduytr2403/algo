import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ')') st.push(c + "");
            else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (st.empty()) break;
                    String t = st.pop();
                    if (!"(".equals(t)) sb.append(t);
                    else break;
                }
                st.push(sb.reverse().toString());
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}
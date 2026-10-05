import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(-1);
            } else {
                int sum = 0;
                while (!st.empty()) {
                    int t = st.pop();
                    if (t == -1) break;
                    else sum += t;
                }
                st.push(sum == 0 ? 1 : 2 * sum);
            }
        }

        while (!st.empty()) res += st.pop();
        return res;
    }
}
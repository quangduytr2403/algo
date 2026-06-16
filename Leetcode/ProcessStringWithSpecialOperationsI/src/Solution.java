class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (sb.isEmpty()) continue;
                sb.deleteCharAt(sb.length() - 1);
            }
            else if (c == '#') {
                String q = sb.toString();
                sb.append(q);
            }
            else if (c == '%') sb.reverse();
            else sb.append(c);
        }

        return sb.toString();
    }
}
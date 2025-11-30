class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s, res = "";
        boolean check;

        for (int i = 1; i <= strs[0].length(); i++) {
            check = true;
            s = strs[0].substring(0, i);

            for (String str : strs) {
                if (!str.startsWith(s)) {
                    check = false;
                    break;
                }
            }

            if (!check) break;
            else res = s;
        }

        return res;
    }
}
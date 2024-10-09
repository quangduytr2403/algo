class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int open = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            else {
                if (open == 0) res++;
                else open--;
            }
        }
        return res + open;
    }
}
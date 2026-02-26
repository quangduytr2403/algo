class Solution {
    public int numSteps(String s) {
        int res = 0, idx;

        while(!"1".equals(s)) {
            res++;
            if (s.charAt(s.length() - 1) == '0') s = s.substring(0, s.length() - 1);
            else {
                idx = -1;
                for (int i = s.length() - 1; i >= 0; i--)
                    if (s.charAt(i) == '0') {
                        idx = i;
                        break;
                    }
                if (idx == -1) s = "1" + "0".repeat(s.length());
                else s = s.substring(0, idx) + "1" + "0".repeat(s.length() - idx - 1);
            }
        }

        return res;
    }
}
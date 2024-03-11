class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res  = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (order.charAt(i) == s.charAt(j)) {
                    res.append(s.charAt(j));
                } else {
                    tmp.append(s.charAt(j));
                }
            }
            s = tmp.toString();
        }

        return res.toString() + s;
    }
}
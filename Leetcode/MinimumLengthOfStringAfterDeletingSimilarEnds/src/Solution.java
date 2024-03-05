class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1) return 1;

        int idxFirst = 0;
        int idxLast = s.length() - 1;
        int res = s.length();


        while (true) {
            if (s.charAt(idxFirst) != s.charAt(idxLast)) return res;

            char c = s.charAt(idxFirst);
            res -= 2;
            idxFirst++;
            idxLast--;

            while (idxFirst <= idxLast && s.charAt(idxFirst) == c) {
                idxFirst++;
                res--;
            }

            while (idxFirst <= idxLast && s.charAt(idxLast) == c) {
                idxLast--;
                res--;
            }

            if (idxFirst >= idxLast) return res;
        }
    }
}
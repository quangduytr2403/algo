class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        String t;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                StringBuilder sb = new StringBuilder(s1);
                sb.setCharAt(i, s1.charAt(j));
                sb.setCharAt(j, s1.charAt(i));

                t = sb.toString();
                if (t.equals(s2)) return true;
            }
        }

        return s1.equals(s2);
    }
}
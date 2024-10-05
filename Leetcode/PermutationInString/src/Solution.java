import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String s1Sorted = Arrays.toString(s1Array);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            char[] s2Array = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(s2Array);
            String s2Sorted = Arrays.toString(s2Array);
            if(s1Sorted.equals(s2Sorted)) return true;
        }

        return false;
    }
}
class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)) {
            int i = s.indexOf(part);
            s = s.substring(0, i) + s.substring(i + part.length());
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeOccurrences("daabcbaabcbc", "abc"));
    }
}
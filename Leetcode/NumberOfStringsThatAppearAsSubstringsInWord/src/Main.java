class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String p : patterns) res += word.contains(p) ? 1 : 0;

        return res;
    }
}
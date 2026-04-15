class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) res = Math.min(res, Math.min(words.length - Math.abs(i - startIndex), Math.abs(i - startIndex)));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
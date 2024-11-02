class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        for(int i = 0; i < split.length; i++) {
            int next = i + 1;
            if (i == split.length - 1) next = 0;
            if (split[i].charAt(split[i].length() - 1) != split[next].charAt(0)) return false;
        }

        return true;
    }
}
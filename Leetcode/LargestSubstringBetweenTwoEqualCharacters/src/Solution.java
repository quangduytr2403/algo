import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int charIndxMp[] = new int[26];
        Arrays.fill(charIndxMp, -1);
        int maxSubLen = -1;
        for(int indx = 0; indx < s.length(); indx++){
            int currChar = s.charAt(indx) - 'a';
            if(charIndxMp[currChar] != -1){
                maxSubLen = Math.max(maxSubLen, indx - charIndxMp[currChar] - 1);
            }else
                charIndxMp[currChar] = indx;
        }
        return maxSubLen;
    }
}
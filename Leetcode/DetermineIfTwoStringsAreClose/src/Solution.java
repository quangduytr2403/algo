import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {

        int fqarr1[] = new int[26];
        int fqarr2[] = new int[26];

        for(char c : word1.toCharArray()) {
            fqarr1[c - 'a']++;
        }

        for(char c : word2.toCharArray()) {
            fqarr2[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if((fqarr1[i] == 0 && fqarr2[i] != 0) || (fqarr1[i] != 0 && fqarr2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(fqarr1);
        Arrays.sort(fqarr2);

        for(int i = 0; i < 26; i++) {
            if(fqarr1[i] != fqarr2[i]) {
                return false;
            }
        }
        return true;

    }
}
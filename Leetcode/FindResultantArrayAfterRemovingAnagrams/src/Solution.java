import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        boolean find;
        char[] c1;
        char[] c2;
        List<String> lword = new ArrayList<>(Arrays.asList(words));
        while (true) {
            find = false;
            for (int i = 0; i < lword.size() - 1; i++) {
                c1 = lword.get(i).toCharArray();
                c2 = lword.get(i + 1).toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);
                if (Arrays.compare(c1, c2) == 0) {
                    find = true;
                    lword.remove(i + 1);
                }
            }
            if (!find) break;
        }

        return lword;
    }
}
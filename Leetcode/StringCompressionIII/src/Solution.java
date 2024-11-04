class Solution {
    public String compressedString(String word) {
        word = " " + word + " ";
        String res = "";
        int count = 0;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(i - 1)) {
                if (count > 0) {
                    while (count > 0) {
                        if (count >= 9) res += ("9" + word.charAt(i -1));
                        else res += (String.valueOf(count) + word.charAt(i -1));
                        count -= 9;
                    }
                }
                count = 1;
            } else count++;
        }

        return res;
    }
}
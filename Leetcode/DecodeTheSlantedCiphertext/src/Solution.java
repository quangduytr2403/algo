class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length() / rows;
        StringBuilder res = new StringBuilder();
        int cur;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rows; j++) {
                cur = i + (n + 1) * j;
                if (cur < encodedText.length()) res.append(encodedText.charAt(cur));
            }
        }

        return res.toString().stripTrailing();
    }
}
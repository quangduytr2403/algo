class Solution {
    public int maximumLength(String s) {
        int res = -1;
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);

                boolean check = true;
                for (int k = 0; k < str.length() - 1; k ++) {
                    if (str.charAt(k) != str.charAt(k + 1)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    int count = 0;
                    for (int k = 0; k < s.length() - str.length() + 1; k++) {
                        if (str.equals(s.substring(k, k + str.length()))) count++;
                    }
                    if (count >= 3) res = Math.max(res, str.length());
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("abcccccdddd"));
    }
}
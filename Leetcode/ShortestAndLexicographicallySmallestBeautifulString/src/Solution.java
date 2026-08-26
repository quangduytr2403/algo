class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int one, max = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++) {
                one = 0;
                for (int l = i; l <= j; l++) {
                    if (s.charAt(l) == '1') one++;
                }
                int length = s.substring(i, j + 1).length();
                if (one == k && (length < max || (length == max && (res.isEmpty() || s.substring(i, j + 1).compareTo(res) < 0)))) {
                    res = s.substring(i, j + 1);
                    max = res.length();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestBeautifulSubstring("101", 1));
    }
}
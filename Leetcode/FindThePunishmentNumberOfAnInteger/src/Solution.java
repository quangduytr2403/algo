class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) if (check( String.valueOf(i * i), i)) res += i * i;
        return res;
    }

    public boolean check(String s, int i){
        if (s.isEmpty()) return i == 0;
        boolean checkVal = false;
        for (int j = 1; j <= s.length(); j++) {
            if (Integer.parseInt(s.substring(0, j)) <= i) {
                checkVal = check(s.substring(j), i - Integer.parseInt(s.substring(0, j)));
                if (checkVal) break;
            }
        }
        return checkVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check("81", 9));
    }
}
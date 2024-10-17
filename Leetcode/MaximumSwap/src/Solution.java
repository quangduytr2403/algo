import java.util.Arrays;

class Solution {
    public int maximumSwap(int num) {
        String s = "" + num;
        int res = num;

        for (int i = 0; i  < s.length(); i ++) {
            for (int j = i + 1; j < s.length(); j++) {
                char[] sArray = s.toCharArray();
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                String sRes = new String(sArray);
                res = Math.max(res, Integer.parseInt(sRes));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(2736));
    }
}
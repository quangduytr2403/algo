class Solution {
    public int numSub(String s) {
        long res = 0;
        int count = 0;

        s += '0';
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res += (((long) count * (count + 1)) / 2) % 1000000007;
                count = 0;
            } else count++;
        }

        return (int) res;
    }
}
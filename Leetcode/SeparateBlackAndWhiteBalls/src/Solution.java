class Solution {
    public long minimumSteps(String s) {
        long sumIndex = 0;
        long sumZero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sumZero++;
                sumIndex += i;
            }
        }

        sumZero = (sumZero - 1) * sumZero / 2;

        return sumIndex - sumZero;
    }
}
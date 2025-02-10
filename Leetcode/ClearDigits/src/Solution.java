class Solution {
    public String clearDigits(String s) {
        while (true) {
            int firstDigit = -1;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    firstDigit = i;
                    break;
                }
            }

            if (firstDigit != -1) {
                if (firstDigit == 0) {
                    s = s.substring(1);
                } else {
                    s = s.substring(0, firstDigit - 1) + s.substring(firstDigit + 1);
                }
            } else break;
        }

        return s;
    }
}
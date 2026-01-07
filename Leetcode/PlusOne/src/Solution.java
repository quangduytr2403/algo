class Solution {
    public int[] plusOne(int[] digits) {
        boolean check9 = true;

        for (int d : digits) {
            if (d != 9) {
                check9 = false;
                break;
            }
        }

        if (check9) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        int remain = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += remain;
            if (digits[i] == 10) {
                digits[i] = 0;
                remain = 1;
            } else remain = 0;
        }

        return digits;
    }
}
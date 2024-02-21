class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        boolean[] leftb = new boolean[31];
        boolean[] rightb = new boolean[31];
        boolean[] res = new boolean[31];
        boolean diff = false;
        int result = 0;

        for (int i = 0; i < 31; i++) {
            leftb[i] = (left & (1 << i)) != 0;
            rightb[i] = (right & (1 << i)) != 0;
        }

        for (int i = 30; i >=0; i--) {
            res[i] = leftb[i] && rightb[i];
            if(diff) res[i] = false;
            if(leftb[i] != rightb[i]) {
                diff = true;
            }
        }

        for(int i = 0; i < 31; i++) {
            if(res[i]) {
                result += (1 << i);
            }
        }

        return result;
    }
}
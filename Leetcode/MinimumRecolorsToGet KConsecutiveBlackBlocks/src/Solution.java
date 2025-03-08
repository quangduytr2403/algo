class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countB = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') countB++;
        }

        int res = k - countB;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') countB++;
            if (blocks.charAt(i - k) == 'B') countB--;

            res = Math.min(res, k - countB);
        }

        return res;
    }
}
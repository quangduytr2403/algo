class Solution {
    public int trap(int[] height) {
        int mLeft[] = new int[height.length];
        int mRight[] = new int[height.length];
        int max = -1;
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            mRight[i] = max;
            max = Math.max(height[i], max);
        }
        max = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            mLeft[i] = max;
            max = Math.max(height[i], max);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(mLeft[i], mRight[i]) - height[i]);
        }

        return res;
    }
}
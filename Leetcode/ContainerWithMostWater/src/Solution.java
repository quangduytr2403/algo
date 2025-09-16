class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            res = Math.max(res, (p2 - p1) * Math.min(height[p1], height[p2]));

            if (height[p1] < height[p2]) p1++;
            else p2--;
        }

        return res;
    }
}
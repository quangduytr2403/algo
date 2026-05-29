class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        String s;
        int t;

        for (int i = 0; i < nums.length; i++) {
            s = Integer.toString(nums[i]);
            t = 0;
            for (int j = 0; j < s.length(); j++) {
                t += s.charAt(j) - '0';
            }
            res = Math.min(res, t);
        }

        return res;
    }
}
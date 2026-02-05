class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[(i + nums[i] + 100 * nums.length) % nums.length];
        }

        return res;
    }
}
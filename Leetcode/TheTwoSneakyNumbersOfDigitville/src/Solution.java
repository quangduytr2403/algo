class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] mark = new int[nums.length];
        int c = 0;
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            mark[nums[i]] ++;
            if (mark[nums[i]] == 2) {
                res[c] = nums[i];
                if (c == 1) return res;
                c++;
            }
        }

        return res;
    }
}
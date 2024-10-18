class Solution {
    int max = Integer.MIN_VALUE;
    int res = 0;

    public int countMaxOrSubsets(int[] nums) {
        int[] c = new int[nums.length];
        fill(nums, c, 0);
        return res;
    }

    public void fill(int[] nums, int[] c, int index) {
        if (index == nums.length) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                if (c[i] == 1) total |= nums[i];
            }
            if (total > max) {
                max = total;
                res = 1;
            } else if (total == max) {
                res++;
            }

            return;
        }

        c[index] = 0;
        fill(nums, c, index + 1);

        c[index] = 1;
        fill(nums, c, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 1}));
    }
}
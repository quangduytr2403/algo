class Solution {
    // Max size is 30
    public int longestNiceSubarray(int[] nums) {
        int res = 1;

        for (int i = 2; i <= 30; i++) {
            for (int j = 0; j <= nums.length - i ; j++) {
                boolean check = true;
                for (int k = 0; k < i; k++) {
                    for (int l = k + 1; l < i; l++) {
                        if ((nums[j + k] & nums[j + l]) != 0) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) break;
                }
                if (check) {
                    res = i;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubarray(new int[]{1,3,8,48,10}));
    }
}
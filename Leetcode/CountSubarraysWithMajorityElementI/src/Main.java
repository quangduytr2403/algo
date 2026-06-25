class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] d = new int[nums.length];
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            d[i] = i > 0 ? d[i - 1] : 0;
            if (nums[i] == target) d[i]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (d[i] > (i + 1) / 2 && d[i] > 0) res++;
            for (int j = 0; j <= i - 1; j++) {
                if (d[i] - d[j] > (i - j) / 2 && d[i] - d[j] > 0) res++;
            }
        }

        return res;
    }
}
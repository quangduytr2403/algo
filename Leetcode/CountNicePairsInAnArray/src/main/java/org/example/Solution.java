package org.example;

import java.util.HashMap;

class Solution {
    public int rev(int num) {
        int r = 0;
        while (num != 0) {
            int k = num % 10;
            r = r * 10 + k;
            num = num / 10;
        }
        return r;
    }

    public int countNicePairs(int[] nums) {
        int mod = (int) Math.pow(10, 9) + 7;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = rev(nums[i]);
            int k = (nums[i] - r);
            int a = hm.getOrDefault(k, 0);
            ans = (ans + a) % mod;
            hm.put(k, a + 1);
        }
        return ans % mod;
    }
}
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] trace = new int[value];
        int m = Integer.MAX_VALUE;
        int mod;
        for (int num : nums) {
            mod = num %value;
            if (mod < 0) mod += value;
            trace[mod]++;
        }

        for (int i : trace) {
            m = Math.min(m, i);
        }

        int index = -1;
        for (int i = 0; i < trace.length; i++) {
            if (trace[i] == 0) return i;
            if (index == -1 && trace[i] == m) index = i;
        }

        return m * value + index;
    }
}
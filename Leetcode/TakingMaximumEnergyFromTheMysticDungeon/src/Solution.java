class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] m = new int[energy.length];
        int res = Integer.MIN_VALUE;

        for (int i = energy.length - 1; i >= 0; i--) {
            m[i % k] = m[i % k] + energy[i];
            res = Math.max(m[i % k], res);
        }

        return res;
    }
}
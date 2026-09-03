class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEve = Integer.MAX_VALUE;

        for (int n : nums1) {
            if (n % 2 == 0) minEve = Math.min(minEve, n);
            else minOdd = Math.min(minOdd, n);
        }

        if (minOdd == Integer.MAX_VALUE || minEve == Integer.MAX_VALUE) return true;
        else return minEve > minOdd;
    }
}
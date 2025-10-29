class Solution {
    public int smallestNumber(int n) {
        return n | (int) (Math.pow(2, (int) (Math.log(n) / Math.log(2)) + 1) -1);
    }
}
class Solution {
    public int reverseBits(int n) {
        String bin = Integer.toBinaryString(n);
        return Integer.parseInt(new StringBuilder(String.format("%32s", bin).replaceAll(" ", "0")).reverse().toString(), 2);
    }
}
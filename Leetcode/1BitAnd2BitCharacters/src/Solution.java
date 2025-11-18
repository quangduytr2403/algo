class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int last = 1;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                last = 1;
            }
            else {
                last = 2;
                i++;
            }
        }

        return last == 1;
    }
}
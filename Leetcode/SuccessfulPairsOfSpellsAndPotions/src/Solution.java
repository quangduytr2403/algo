import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] trace = new int[100002];
        Arrays.sort(potions);
        int pt = potions.length - 1;
        int count;
        double a;

        for (int i = 100000; i >= 1; i--) {
            count = 0;
            while (pt >= 0 && potions[pt] == i) {
                count++;
                pt--;
            }
            trace[i] = trace[i + 1] + count;
        }

        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            a = (double) success / spells[i];
            res[i] = a > 100000 ? 0 : trace[(int) Math.ceil(a)];
        }

        return res;
    }
}
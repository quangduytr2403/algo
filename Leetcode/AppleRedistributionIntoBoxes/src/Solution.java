import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int res = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            res++;
            if (sum <= 0) break;
        }

        return res;
    }
}
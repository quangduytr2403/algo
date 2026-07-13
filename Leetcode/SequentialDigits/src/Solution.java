import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l = new ArrayList<>();
        int t;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9 - i + 1; j++) {
              t = 0;
              for (int k = 0; k < i; k++) {
                  t = t * 10 + (j + k);
              }

              if (low <= t && t <= high) l.add(t);
            }
        }

        return l;
    }
}
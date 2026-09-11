import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0 ; j < digits.length; j++) {
                if (j != i) {
                    for (int k = 0; k < digits.length; k++) {
                        if (digits[i] != 0 && digits[k] % 2 == 0 && k != i && k != j) s.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }

        return s.size();
    }
}
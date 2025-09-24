import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (den < 0) {
            num = -num;
            den = -den;
        }
        long pre = num / den;
        long mod = Math.abs(num % den);
        if (mod == 0) return String.valueOf(pre);

        Map<Long, Integer> m = new HashMap<>();
        String res = (num < 0 && pre == 0 ? "-" : "") + pre + ".";
        String after = "";
        while (mod != 0) {
            if (m.containsKey(mod)) {
                return res + after.substring(0, m.get(mod) - 1) + "(" + after.substring(m.get(mod) - 1) + ")";
            }
            after += ((mod * 10L) / den);
            m.put(mod, after.length());
            mod = ((mod * 10L) % den);
        }
        return res + after;
    }
}
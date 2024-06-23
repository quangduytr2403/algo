import java.util.ArrayList;
import java.util.List;

class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        List<Feq> feqs = new ArrayList<>();

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                feqs.add(new Feq(i, freq[i]));
            }
        }

        feqs.sort((a, b) -> b.i - a.i);

        StringBuilder sb = new StringBuilder();

        for (Feq feq : feqs) {
            for (int i = 0; i < feq.i; i++) {
                sb.append((char) feq.c);
            }
        }

        return sb.toString();
    }

    class Feq {
        int c;
        int i;

        Feq(int c, int i) {
            this.c = c;
            this.i = i;
        }
    }
}
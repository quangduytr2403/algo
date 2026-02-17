import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        String h, m;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    h = String.valueOf(i);
                    m = String.valueOf(j);
                    if (j < 10) m = "0" + m;
                    res.add(h + ":" + m);
                }
            }
        }

        return res;
    }
}
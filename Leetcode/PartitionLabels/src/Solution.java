import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer[]> idx = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int firstIdx;
        int lastIdx;
        for (int i = 0; i < 26; i++) {
            firstIdx = -1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'a' + i) {
                    firstIdx = j;
                    break;
                }
            }
            if (firstIdx == -1) continue;
            lastIdx = firstIdx;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == 'a' + i) {
                    lastIdx = j;
                    break;
                }
            }

            idx.add(new Integer[]{firstIdx, lastIdx});
        }
        // Dummy
        idx.add(new Integer[]{s.length(), s.length()});

        idx.sort(Comparator.comparingInt(a -> a[0]));

        int curFirst = -1;
        int curLast = -1;
        for (Integer[] i : idx) {
            if (i[0] > curLast) {
                if (curFirst != -1) res.add(curLast - curFirst + 1);
                curFirst = i[0];
                curLast = i[1];
            } else {
                curLast = Math.max(curLast, i[1]);
            }
        }

        return res;
    }
}
import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            m.put(score[i], i);
        }
        Arrays.sort(score);
        String[] res = new String[score.length];

        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) {
                res[m.get(score[i])] = "Gold Medal";
            } else if (i == score.length - 2)
                res[m.get(score[i])] = "Silver Medal";
            } else if (i == score.length - 3) {
                res[m.get(score[i])] = "Bronze Medal";
            } else {
                res[m.get(score[i])] = "" + (score.length - i);
            }
        }

        return res;
    }
}
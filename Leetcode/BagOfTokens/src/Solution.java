import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int idxFirst = 0;
        int idxLast = tokens.length - 1;
        int res = 0;
        int score = 0;
        while (true) {
            if(idxFirst > idxLast) break;

            if (power >= tokens[idxFirst]) {
                power -= tokens[idxFirst];
                idxFirst++;
                score++;
                res = Math.max(score, res);
                continue;
            }

            if (score >= 1) {
                power += tokens[idxLast];
                idxLast--;
                score--;
                continue;
            }

            break;
        }

        return res;
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestBalanced(String s) {
        int res = 0, curr = 0, countA = 0, countB = 0, countC = 0, hash;
        Map<Integer, Integer> mapAb = new HashMap<>();
        Map<Integer, Integer> mapBc = new HashMap<>();
        Map<Integer, Integer> mapCa = new HashMap<>();
        Map<Integer, Integer> mapAbc = new HashMap<>();

        mapAbc.put(0, -1);
        mapAb.put(0, -1);
        mapBc.put(0, -1);
        mapCa.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == s.charAt(i)) curr++;
            else {
                res = Math.max(res, curr);
                curr = 1;
            }

            if (s.charAt(i) == 'a') countA++;
            else if (s.charAt(i) == 'b') countB++;
            else countC++;

            if (!mapAb.containsKey(countA - countB)) mapAb.put(countA - countB, i);
            else if (s.charAt(i) != 'c') res = Math.max(res, i - mapAb.get(countA - countB));
            if (!mapBc.containsKey(countB - countC)) mapBc.put(countB - countC, i);
            else if (s.charAt(i) != 'a') res = Math.max(res, i - mapBc.get(countB - countC));
            if (!mapCa.containsKey(countC - countA)) mapCa.put(countC - countA, i);
            else if (s.charAt(i) != 'b') res = Math.max(res, i - mapCa.get(countC - countA));

            hash = (countA - countB) * 1_000_000 + (countB - countC);
            if (!mapAbc.containsKey(hash)) mapAbc.put(hash, i);
            else res = Math.max(res, i - mapAbc.get(hash));

            if (s.charAt(i) == 'a') {
                mapBc = new HashMap<>();
                mapBc.put(countB - countC, i);
            }
            else if (s.charAt(i) == 'b'){
                mapCa = new HashMap<>();
                mapCa.put(countC - countA, i);
            }
            else {
                mapAb = new HashMap<>();
                mapAb.put(countA - countB, i);
            }
        }
        res = Math.max(res, curr);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestBalanced("aabcc"));
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> mapLeft = new HashMap<>();
        Map<Character, Integer> mapRight = new HashMap<>();
        int res = 0;

        for (char c : s.toCharArray()) {
            mapRight.put(c, mapRight.containsKey(c) ? mapRight.get(c) + 1 : 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            mapLeft.put(c, mapLeft.containsKey(c) ? mapLeft.get(c) + 1 : 1);
            if (mapRight.get(c) == 1) {
                mapRight.remove(c);
            } else {
                mapRight.put(c, mapRight.get(c) - 1);
            }

            if (mapLeft.keySet().size() == mapRight.keySet().size()) res++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSplits("aacaba"));
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(s.charAt(i), l);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)).size() == 1) {
                res = Math.min(res, map.get(s.charAt(i)).get(0));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
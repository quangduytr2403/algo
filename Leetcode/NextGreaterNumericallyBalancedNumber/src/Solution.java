import java.util.HashMap;
import java.util.Map;

class Solution {
    public int nextBeautifulNumber(int n) {
        Map<Integer, Integer> m;
        boolean check;
        int t;
        for (int i = n + 1; i <= 1224444; i++) {
            m = new HashMap<>();
            t = i;
            while (t > 0) {
                m.put(t % 10, m.getOrDefault(t % 10, 0) + 1);
                t = t / 10;
            }
            check = true;
            for (var e : m.entrySet()) {
                if (!e.getKey().equals(e.getValue())) {
                    check = false;
                    break;
                }
            }
            if (check) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextBeautifulNumber(1));
    }
}
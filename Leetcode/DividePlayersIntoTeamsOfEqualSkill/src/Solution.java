import java.util.HashMap;
import java.util.Map;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Map<Integer, Integer> count = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < skill.length; i++) {
            int s = skill[i];
            if (!count.containsKey(s)) count.put(s, 0);
            count.put(s, count.get(s) + 1);
            sum += s;
        }

        if (sum % (n / 2) != 0) return -1;
        int totalSkill = sum / (n / 2);

        long res = 0;
        for (var e : count.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();

            if (totalSkill % 2 == 0 && key == totalSkill / 2) {
                if (value % 2 == 1) return -1;
                long tmp = ((long) key * key) * (value / 2);
                res += tmp;
            } else {
                if (!count.containsKey(totalSkill - key) || count.get(totalSkill-key) != value) return -1;
                else {
                    if (key < (double) totalSkill / 2) {
                        long tmp = ((long) key * (totalSkill - key)) * value;
                        res += tmp;
                    }
                }
            }
        }

        return res;
    }
}
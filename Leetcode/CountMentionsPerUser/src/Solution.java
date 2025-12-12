import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] status = new int[numberOfUsers];
        int[] res = new int[numberOfUsers];
        events.sort((e1, e2) -> Integer.parseInt(e1.get(1)) == Integer.parseInt(e2.get(1))
                ? e2.get(0).compareTo(e1.get(0))
                : Integer.parseInt(e1.get(1)) - Integer.parseInt(e2.get(1)));
        String[] token;
        int id;

        for (var e : events) {
            for (int i = 0; i < numberOfUsers; i++) {
                if (status[i] + 60 <= Integer.parseInt(e.get(1))) status[i] = 0;
            }

            if ("MESSAGE".equals(e.get(0))) {
                token = e.get(2).split(" ");

                for (String s : token) {
                    if ("ALL".equals(s)) {
                        for (int k = 0; k < numberOfUsers; k++) res[k]++;
                    } else if ("HERE".equals(s)) {
                        for (int k = 0; k < numberOfUsers; k++) if (status[k] == 0) res[k]++;
                    } else {
                        id = Integer.parseInt(s.substring(2));
                        res[id]++;
                    }
                }
            } else {
                id = Integer.parseInt(e.get(2));
                status[id] = Integer.parseInt(e.get(1));
            }
        }

        return res;
    }
}
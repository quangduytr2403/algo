import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Integer>> l = new ArrayList<>();
        int[] tmp;
        int res = Integer.MAX_VALUE;

        for (int[] e : edges) {
            l.add(Arrays.stream(e).boxed().toList());
            tmp = new int[]{e[1], e[0], 2 * e[2]};
            l.add(Arrays.stream(tmp).boxed().toList());
        }
        l.sort((l1, l2) -> l1.get(0).equals(l2.get(0)) ? (l1.get(1).equals(l2.get(1)) ? l1.get(2) - l2.get(2) : l1.get(1) - l2.get(1)) : (l1.get(0) - l2.get(0)) );

        Map<Integer, List<Integer[]>> edgeMap =
            l.stream()
                .collect(Collectors.groupingBy(
                        litem -> litem.get(0),
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        litem -> litem.get(1),                 // unique by get(1)
                                        litem -> new Integer[]{litem.get(1), litem.get(2)},
                                        (a, b) -> a                             // keep first if duplicate
                                ),
                                m -> new ArrayList<>(m.values())
                        )
                ));

        boolean[] visited = new boolean[n];
        PriorityQueue<Integer[]> p = new PriorityQueue<>(Comparator.comparingInt(p2 -> p2[1]));
        p.add(new Integer[]{0, 0});
        visited[0] = true;

        while (!p.isEmpty()) {
            Integer[] cost = p.poll();
            visited[cost[0]] = true;

            if (edgeMap.get(cost[0]) == null) continue;
            for (int i = 0; i < edgeMap.get(cost[0]).size(); i++) {
                Integer[] e = edgeMap.get(cost[0]).get(i);
                if (!visited[e[0]]) {
                    p.add(new Integer[]{e[0], cost[1] + e[1]});

                    if (e[0] == n - 1)  res = Math.min(res, cost[1] + e[1]);
                }
            }
        }

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
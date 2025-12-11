import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] d = new int[buildings.length][3];
        Map<Integer, List<Integer>> mx = new HashMap<>();
        Map<Integer, List<Integer>> my = new HashMap<>();
        int[] c = new int[buildings.length];
        int res = 0;

        for (int i = 0; i < buildings.length; i++) {
            d[i][0] = i;
            d[i][1] = buildings[i][0];
            d[i][2] = buildings[i][1];
        }

        Arrays.sort(d, (d1, d2) -> d1[1] == d2[1] ? d1[2] - d2[2] : d1[1] - d2[1]);

        for (int i = 0; i < buildings.length; i++) {
            if (!mx.containsKey(d[i][1])) mx.put(d[i][1], new ArrayList<>());
            mx.get(d[i][1]).add(d[i][0]);
        }

        for (var k : mx.keySet()) {
            for (int i = 1; i < mx.get(k).size() - 1; i++) c[mx.get(k).get(i)]++;
        }

        Arrays.sort(d, (d1, d2) -> d1[2] == d2[2] ? d1[1] - d2[1] : d1[2] - d2[2]);

        for (int i = 0; i < buildings.length; i++) {
            if (!my.containsKey(d[i][2])) my.put(d[i][2], new ArrayList<>());
            my.get(d[i][2]).add(d[i][0]);
        }

        for (var k : my.keySet()) {
            for (int i = 1; i < my.get(k).size() - 1; i++) {
                c[my.get(k).get(i)]++;
                if (c[my.get(k).get(i)] == 2) res++;
            }
        }
        return res;
    }
}
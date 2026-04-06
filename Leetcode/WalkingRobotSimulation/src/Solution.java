import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, List<Integer>> mapx = new HashMap<>();
        Map<Integer, List<Integer>> mapy = new HashMap<>();
        int res = 0;
        int curX = 0, curY = 0;
        int curD = 0;
        List<Integer> l;

        for (int[] o : obstacles) {
            if (!mapx.containsKey(o[0])) mapx.put(o[0], new ArrayList<>());
            mapx.get(o[0]).add(o[1]);
            if (!mapy.containsKey(o[1])) mapy.put(o[1], new ArrayList<>());
            mapy.get(o[1]).add(o[0]);
        }

        for (int c : commands) {
            if (c == -2) {
                curD--;
                if (curD < 0) curD += 4;
                continue;
            } else if (c == -1) {
                curD++;
                if (curD >= 4) curD -= 4;
                continue;
            }
            if (curD % 2 == 0) {
                l = mapx.get(curX);
                if (l != null && !l.isEmpty()) {
                    l.sort(Comparator.comparingInt(i -> i));
                    if (curD == 0) c = findMin(curY + 1, curY + c, 0, l.size() - 1 , l, c);
                    else c = findMax(curY - c, curY - 1, 0, l.size() - 1, l, c);
                }
                if (curD == 0) curY += c;
                else curY -= c;
            } else {
                l = mapy.get(curY);
                if (l != null && !l.isEmpty()) {
                    l.sort(Comparator.comparingInt(i -> i));
                    if (curD == 1) c = findMin(curX + 1, curX + c, 0, l.size() - 1, l, c);
                    else c = findMax(curX - c, curX - 1, 0, l.size() - 1, l, c);
                }

                if (curD == 1) curX += c;
                else curX -= c;
            }

            res = Math.max(res, curX * curX + curY * curY);
        }

        return res;
    }

    int findMin(int min, int max, int l, int r, List<Integer> vals, int maxDis) {
        if (l >= r - 1) {
            for (int i = l; i <= r; i++) {
                if (vals.get(i) >= min && vals.get(i) <= max) return vals.get(i) - min;
            }

            return maxDis;
        }

        int m = (l + r) / 2;
        if (vals.get(m) >= min && vals.get(m) <= max) return findMin(min, max, l, m, vals, maxDis);
        else if (vals.get(m) < min) return findMin(min, max, m + 1, r, vals, maxDis);
        else return findMin(min, max, l, m - 1, vals, maxDis);
    }

    int findMax(int min, int max, int l, int r, List<Integer> vals, int maxDis) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (vals.get(i) >= min && vals.get(i) <= max) return max - vals.get(i);
            }

            return maxDis;
        }

        int m = (l + r) / 2;
        if (vals.get(m) >= min && vals.get(m) <= max) return findMax(min, max, m, r, vals, maxDis);
        else if (vals.get(m) < min) return findMax(min, max, m + 1, r, vals, maxDis);
        else return findMax(min, max, l, m - 1, vals, maxDis);
    }

    public static void main(String[] args) {
        int[][] obs = {{0, 1}, {0, -3}};
        System.out.println(new Solution().robotSim(new int[]{7,-2,-2,7,5}, obs));
    }
}
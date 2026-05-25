import java.util.*;

class Solution {
    List<Integer> idxs = new ArrayList<>();

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.length() == 1) return true;
        if (s.charAt(s.length() - 1) == '1') return false;
        boolean[] visited = new boolean[s.length()];
        visited[0] = true;
        if (s.charAt(0) == '0') idxs.add(0);

        for (int i = 1 ; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                int minIdx = findMin(0, idxs.size() - 1, i - maxJump);
                int maxIdx = findMax(0, idxs.size() - 1, i - minJump);
                System.out.println(minIdx);
                System.out.println(maxIdx);
                if (minIdx == -1 || maxIdx == -1) continue;
                for (int j = minIdx; j <= maxIdx; j++) {
                    if (visited[idxs.get(j)]) {
                        visited[i] = true;
                        break;
                    }
                }
                idxs.add(i);
            }
        }

        return visited[s.length() - 1];
    }

    int findMin(int l, int r, int maxDis) {
        if (l >= r - 1) {
            for (int i = l; i <= r; i++) {
                if (idxs.get(i) >= maxDis) return i;
            }

            return -1;
        }

        int m = (l + r) / 2;
        if (idxs.get(m) >= maxDis) return findMin(l, m, maxDis);
        else return findMin(m + 1, r, maxDis);
    }

    int findMax(int l, int r, int minDis) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (idxs.get(i) <= minDis) return i;
            }

            return -1;
        }

        int m = (l + r) / 2;
        if (idxs.get(m) <= minDis) return findMax(m, r, minDis);
        else return findMax(l, m - 1, minDis);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canReach("011010", 2, 3));
    }
}
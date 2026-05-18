import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        int[] t;
        List<Integer> idx;

        for (int i = 0; i < arr.length; i++) {
            if (!m.containsKey(arr[i])) m.put(arr[i], new ArrayList<>());
            m.get(arr[i]).add(i);
        }

        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            t = q.poll();

            if (t[0] > 0 && !visited[t[0] - 1]) {
                q.add(new int[]{t[0] - 1, t[1] + 1});
                visited[t[0] - 1] = true;
            }

            if (t[0] < arr.length - 1 && !visited[t[0] + 1]) {
                if (t[0] + 1 == arr.length - 1) return t[1] + 1;
                q.add(new int[]{t[0] + 1, t[1] + 1});
                visited[t[0] + 1] = true;
            }

            idx = m.get(arr[t[0]]);
            if (idx != null && idx.size() > 1) {
                for (int i = 0; i < idx.size(); i++) {
                    if (idx.get(i) != t[0] && !visited[idx.get(i)]) {
                        if (idx.get(i) == arr.length - 1) return t[1] + 1;
                        q.add(new int[]{idx.get(i), t[1] + 1});
                        visited[idx.get(i)] = true;
                        m.remove(arr[t[0]]);
                    }
                }
            }
        }

        return 0;
    }
}
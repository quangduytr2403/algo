import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new ArrayDeque<>();
        int t;

        q.add(start);

        while (!q.isEmpty()) {
            t = q.poll();

            if (t + arr[t] < arr.length && !visited[t + arr[t]]) {
                if (arr[t + arr[t]] == 0) return true;
                q.add(t + arr[t]);
                visited[t + arr[t]] = true;
            }

            if (t - arr[t] >= 0 && !visited[t - arr[t]]) {
                if (arr[t - arr[t]] == 0) return true;
                q.add(t - arr[t]);
                visited[t - arr[t]] = true;
            }
        }

        return false;
    }
}
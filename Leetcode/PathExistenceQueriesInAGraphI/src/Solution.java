import java.util.*;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] v = new int[n];
        int c = 1;
        boolean[] res = new boolean[queries.length];
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) l.add(i);

        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                v[i] = c;

                while (!q.isEmpty()) {
                    int cur = q.poll();

                    // go left
                    int left = cur - 1;
                    while (left >= 0 &&
                            v[left] == 0 &&
                            nums[left + 1] - nums[left] <= maxDiff) {

                        v[left] = c;
                        q.offer(left);
                        left--;
                    }

                    // go right
                    int right = cur + 1;
                    while (right < n &&
                            v[right] == 0 &&
                            nums[right] - nums[right - 1] <= maxDiff) {

                        v[right] = c;
                        q.offer(right);
                        right++;
                    }
                }
                c++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = v[queries[i][0]] == v[queries[i][1]];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathExistenceQueries(4, new int[]{2,5,6,8}, 2, new int[][]{{0,1}, {0,2}, {1,3}, {2,3}}));
    }
}
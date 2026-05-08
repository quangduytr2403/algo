import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int[] t;
        Map<Integer, List<Integer>> edges = new HashMap<>();

        if (nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> s = getPrimeFactors(nums[i]);

            for (int j : s) {
                if (!edges.containsKey(j)) edges.put(j, new ArrayList<>());
                edges.get(j).add(i);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0] = true;
        while (!q.isEmpty()) {
            t = q.poll();
            if (t[0] > 0 && !visited[t[0] - 1]) {
                q.add(new int[]{t[0] - 1, t[1] + 1});
                visited[t[0] - 1] = true;
            }
            if (t[0] < nums.length - 1 && !visited[t[0] + 1]) {
                q.add(new int[]{t[0] + 1, t[1] + 1});
                if (t[0] + 1 == nums.length - 1) return t[1] + 1;
                else visited[t[0] + 1] = true;
            }
            if (edges.containsKey(nums[t[0]])) {
                for (Integer i : edges.get(nums[t[0]])) {
                    if (!visited[i]) {
                        q.add(new int[]{i, t[1] + 1});
                        if (i == nums.length - 1) return t[1] + 1;
                        else visited[i] = true;
                    }
                }
                edges.remove(nums[t[0]]);
            }
        }

        return -1;
    }

    List<Integer> getPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }

        return factors.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPrimeFactors(7));
    }
}
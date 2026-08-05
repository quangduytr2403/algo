import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build the adjacency list for the directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            graph.get(invocation[0]).add(invocation[1]);
        }

        // Step 2: Use BFS to discover all "suspicious" methods starting from k
        boolean[] isSuspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(k);
        isSuspicious[k] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!isSuspicious[neighbor]) {
                    isSuspicious[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Verify if any external (non-suspicious) method invokes a suspicious method
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                for (int neighbor : graph.get(i)) {
                    // If a non-suspicious method invokes a suspicious one, we cannot remove anything
                    if (isSuspicious[neighbor]) {
                        List<Integer> allMethods = new ArrayList<>();
                        for (int m = 0; m < n; m++) {
                            allMethods.add(m);
                        }
                        return allMethods;
                    }
                }
            }
        }

        // Step 4: If isolation constraint passes, return only non-suspicious methods
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                remaining.add(i);
            }
        }
        return remaining;
    }
}
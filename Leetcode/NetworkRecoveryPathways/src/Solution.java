import java.util.*;

class Solution {
    public class Graph {
        List<int[]> edges;
        int verticeNum;
    }

    public Graph createValidGraph(int[][] edges, boolean[] online) {
        Graph g = new Graph();
        g.edges = new ArrayList<>();
        Set<Integer> vertices = new HashSet<>();
        g.verticeNum = 0;
        for (int[] e : edges) {
            if (online[e[0]] && online[e[1]]) {
                g.edges.add(e);
                if (!vertices.contains(e[0])) {
                    vertices.add(e[0]);
                    g.verticeNum++;
                }
                if (!vertices.contains(e[1])) {
                    vertices.add(e[1]);
                    g.verticeNum++;
                }
            }
        }
        return g;
    }

    public List<List<int[]>> createAdjVertices(List<int[]> edges, int verticeNum) {
        List<List<int[]>> adj = new ArrayList<>(verticeNum);
        for (int i = 0; i < verticeNum; i++) {
            adj.add(new ArrayList<>());
        }
        // Avoid clone
        edges.forEach(e -> adj.get(e[0]).add(e));
        return adj;
    }

    // Dijkstra
    public long getMinDistance(List<List<int[]>> adjByVertice, int from, int to, int minCost, int validVerticeNum, long totalCostLimit) {
        // Distance from "from" to "to";
        long[] dist = new long[adjByVertice.size()];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[from] = 0;
        // long[] = [distination, distance]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(d -> d[1]));
        pq.offer(new long[]{from, -1});
        int visitedCount = 0;
        while (!pq.isEmpty() && visitedCount < validVerticeNum) {
            long[] minDist = pq.poll();
            if (minDist[0] == to) {
                break;
            }
            // minDist[1] = dist[(int)minDist[0]] happens only once because item is pushed to the queue only when distance is smaller. Therefore, minDist[1] is unique in the queue.
            if (minDist[1] > dist[(int)minDist[0]]) {
                continue;
            }
            visitedCount++;
            List<int[]> adj = adjByVertice.get((int)minDist[0]);
            for (int i = adj.size() - 1; i >= 0; i--) {
                int[] e = adj.get(i);
                if (e[2] < minCost) {
                    // Escape when edge cost is smaller than minCost because the adj is sorted.
                    break;
                }
                long newDist = dist[e[0]] + e[2];
                if (newDist < dist[e[1]] && newDist <= totalCostLimit) {
                    dist[e[1]] = newDist;
                    pq.offer(new long[]{e[1], newDist});
                }
            }
        }
        return dist[to];
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        Graph validGraph = createValidGraph(edges, online);
        // Sort in place
        Collections.sort(validGraph.edges, (e1, e2) -> e1[2] - e2[2]);
        // Sorted adj
        List<List<int[]>> adjVertices = createAdjVertices(validGraph.edges, online.length);
        int left = 0;
        int right = validGraph.edges.size() - 1;
        // Store (minimum cost, minimum disnace) in a map to avoid redundant compute.
        Map<Integer, Long>  distances = new HashMap<>();
        int maxPathScore = -1;
        while (left <= right) {
            int median = (left + right) / 2;
            int minCost = validGraph.edges.get(median)[2];
            Long distance = distances.get(minCost);
            if (distance == null) {
                distance = getMinDistance(adjVertices, 0, adjVertices.size() - 1, minCost, validGraph.verticeNum, k);
                distances.put(minCost, distance);
            }

            if (distance <= k) {
                maxPathScore = minCost;
                left = median + 1;
            } else {
                right = median - 1;
            }
        }
        return maxPathScore;
    }
}

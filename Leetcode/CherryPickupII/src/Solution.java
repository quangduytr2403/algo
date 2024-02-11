
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = Integer.MIN_VALUE;
        boolean[][][][] trace = new boolean[row][col][row][col];

        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.x == b. x ? b.sum - a.sum : a.x - b.x);
        queue.add(new Node(0,  0, col-1, grid[0][0] + grid[0][col-1]));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == row - 1) {
                res = Math.max(res, node.sum);
                continue;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (node.y1 + i >= 0 && node.y1 + i < col && node.y2 + j >= 0 && node.y2 + j < col && !trace[node.x + 1][node.y1 + i][node.x + 1][node.y2 + j]) {
                        int newSum;
                        if (node.y1 + i == node.y2 + j) {
                            newSum = node.sum + grid[node.x + 1][node.y1 + i];
                        } else {
                            newSum = node.sum + grid[node.x + 1][node.y1 + i] + grid[node.x + 1][node.y2 + j];
                        }
                        trace[node.x + 1][node.y1 + i][node.x + 1][node.y2 + j] = true;
                        queue.add(new Node(node.x + 1, node.y1 + i, node.y2 + j, newSum));
                    }
                }
            }
        }

        return res;
    }

    class Node {
        int x;
        int y1;
        int y2;
        int sum;

        public Node(int x, int y1, int y2, int sum) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.sum = sum;
        }
    }
}
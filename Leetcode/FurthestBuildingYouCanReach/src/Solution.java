import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diff = new int[heights.length - 1];

        for (int i = 0; i < heights.length - 1; i++) {
            diff[i] = heights[i + 1] - heights[i];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sumByLadder = 0;
        int sumDiff = 0;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                sumDiff += diff[i];
                if(ladders > 0) {
                    if (pq.size() < ladders) {
                        pq.add(diff[i]);
                        sumByLadder += diff[i];
                    } else {
                        if (pq.peek() < diff[i]) {
                            sumByLadder -= pq.poll();
                            pq.add(diff[i]);
                            sumByLadder += diff[i];
                        }
                    }
                }

                if (sumDiff - sumByLadder > bricks) {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}
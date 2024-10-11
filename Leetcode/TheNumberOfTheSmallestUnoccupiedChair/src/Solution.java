import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetTime = times[targetFriend][0];
        Arrays.sort(times, Comparator.comparingInt(t -> t[0]));
        PriorityQueue<Integer[]> busyChairs = new PriorityQueue<>(Comparator.comparingInt(b -> b[1]));
        PriorityQueue<Integer> availChairs = new PriorityQueue<>();
        int currentIndex = 0;
        int currentMaxChair = -1;

        for (int i = 0; i <= 100000; i++) {
            while (!busyChairs.isEmpty() && busyChairs.peek()[1] == i) {
                availChairs.add(busyChairs.poll()[0]);
            }

            if (times[currentIndex][0] == i) {
                int chooseChair;
                if (availChairs.isEmpty()) {
                    currentMaxChair++;
                    chooseChair= currentMaxChair;
                    busyChairs.add(new Integer[]{currentMaxChair, times[currentIndex][1]});
                } else {
                    chooseChair = availChairs.poll();
                    busyChairs.add(new Integer[]{chooseChair, times[currentIndex][1]});
                }

                if (times[currentIndex][0] == targetTime) return chooseChair;
                currentIndex++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1));
    }
}
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int[] ans = new int[n];
        //times will store the end time of the last meeting held in each room.
        long[] times = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean flag = false;
            int minIndex = -1;
            long val = Long.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (times[j] < val) {
                    val = times[j];
                    minIndex = j;
                }
                //At the start time of the meeting, multiple rooms are available, so we can hold the meeting in any room.
                if (times[j] <= start) {
                    flag = true;
                    ans[j]++;
                    times[j] = end;
                    break;
                }
            }
            //Waiting for the next meeting to start in the room with the earliest end time.
            if (!flag) {
                ans[minIndex]++;
                times[minIndex] += (end - start);
            }
        }

        int maxi = -1, id = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxi) {
                maxi = ans[i];
                id = i;
            }
        }
        return id;
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Balloon {
        int s;
        int e;

        public Balloon(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public int findMinArrowShots(int[][] points) {
        List<Balloon> balloons = new ArrayList<>();
        int res = 1;

        for(int i = 0 ; i < points.length; i++) balloons.add(new Balloon(points[i][0], points[i][1]));
        balloons.sort(Comparator.comparingInt(o -> o.s));
        int curE = balloons.get(0).e;

        for(int i = 1; i < points.length; i++) {
            if(balloons.get(i).e <= curE) {
                curE = balloons.get(i).e;
            } else {
                if (balloons.get(i).s > curE) {
                    res++;
                    curE = balloons.get(i).e;
                }
            }
        }

        return res;
    }


}
import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long maxTime = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;
        long minTime = (long) Arrays.stream(ranks).min().getAsInt();

        return find(minTime, maxTime, ranks, cars);
    }

    public long find(long l, long r, int[] ranks, int cars) {
        if (l >= r - 1) {
            for (long i = l; i <= r; i++) {
                if (check(i, ranks, cars)) return i;
            }
            return -1;
        }

        long m = (l + r) / 2;
        if (check(m, ranks, cars)) return find(l, m, ranks, cars);
        else return find(m + 1, r, ranks, cars);
    }

    public boolean check(long time, int[] ranks, int cars) {
        for (int rank : ranks) {
            cars -= (int) Math.sqrt((double) time / rank);
            if (cars <= 0) return true;
        }

        return false;
    }
}
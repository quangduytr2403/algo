import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyCalendarTwo {

    List<int[]> booked = new ArrayList<>();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        boolean canBook = true;
        for (int i = 0; i < booked.size(); i++) {
            int[] b1 = booked.get(i);
            if (Math.max(b1[0], start) < Math.min(b1[1], end)) {
                for (int j = i + 1; j < booked.size(); j++) {
                    int[] b2 = booked.get(j);
                    int insectStart = Math.max(b1[0], b2[0]);
                    int insectEnd = Math.min(b1[1], b2[1]);
                    if (insectStart < insectEnd) {
                        int insectStart2 = Math.max(insectStart, start);
                        int insectEnd2 = Math.min(insectEnd, end);
                        if (insectStart2 < insectEnd2) {
                            canBook = false;
                            break;
                        }
                    }
                }
            }
        }
        if (canBook) {
            booked.add(new int[]{start, end});
        }

        return canBook;
    }
}
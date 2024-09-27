import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyCalendar {

    List<Integer[]> booked = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        boolean canBook = true;
        for (Integer[] b : booked) {
            if (start >= b[1] || end <= b[0]) continue;
            else {
                canBook = false;
                break;
            }
        }
        if (canBook) {
            booked.add(new Integer[]{start, end});
            booked.sort(Comparator.comparingInt(b -> b[0]));
        }

        return canBook;
    }
}
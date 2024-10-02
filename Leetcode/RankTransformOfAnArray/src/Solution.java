import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        List<int[]> l = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int[] data = new int[3];
            data[0] = i;
            data[1] = arr[i];
            l.add(data);
        }

        l.sort(Comparator.comparingInt(data -> data[1]));

        int rank = 1;
        for (int i = 0; i < l.size(); i++) {
            if (i > 0 && l.get(i)[1] != l.get(i - 1)[1]) rank++;
            l.get(i)[2] = rank;
        }

        l.sort(Comparator.comparingInt(data -> data[0]));

        return l.stream()
                .mapToInt(data -> data[2])
                .toArray();
    }
}
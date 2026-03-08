import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of (1);
        else if (rowIndex == 1) return List.of(1, 1);

        List<Integer> l = new ArrayList<>(List.of(1, 1));

        for (int i =  2; i <= rowIndex; i++) {
            for (int j = 0; j < l.size() - 1; j++) l.set(j, l.get(j) + l.get(j + 1));
            l.removeLast();
            l.add(1);
            l.addFirst(1);
        }

        return l;
    }
}
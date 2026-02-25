import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] arrI = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrI, (n1, n2) -> {
            long countN1 = Integer.toBinaryString(n1).chars().filter(c -> c == '1').count();
            long countN2 = Integer.toBinaryString(n2).chars().filter(c -> c == '1').count();
            return Math.toIntExact(countN1 == countN2 ? n1 - n2 : countN1 - countN2);
        });
        return Arrays.stream(arrI).mapToInt(Integer::intValue).toArray();
    }
}
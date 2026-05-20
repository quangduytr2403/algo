import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        Set<Integer> sA = new HashSet<>();
        Set<Integer> sB = new HashSet<>();
        Set<Integer> sI;

        for (int i = 0; i < A.length; i++) {
            sA.add(A[i]);
            sB.add(B[i]);
            sI = new HashSet<>(sA);
            sI.retainAll(sB);
            res[i] = sI.size();
        }

        return res;
    }
}
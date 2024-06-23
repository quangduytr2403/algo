import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        int[] trace = new int[100005];

        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);

        while(!qu.isEmpty()) {
            int tmp =qu.remove();
            if(tmp == n) break;

            for(int i = 1;  i <= (int)Math.sqrt(n - tmp); i++) {
                if(trace[tmp + i * i] == 0) {
                    trace[tmp + i * i] = trace[tmp] + 1;
                    qu.add(tmp + i * i);
                }
            }
        }

        return trace[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(10));
    }
}

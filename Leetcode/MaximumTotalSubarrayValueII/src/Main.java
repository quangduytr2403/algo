import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// O(N*logN) preprocessing
// find min or max in a range in O(1)
class SparseTable{
    int[][] m1, m2;
    int[] log;
    int LOG;
    public SparseTable(int[] a, int n){
        log = new int[n+1];
        log[1] = 0;
        for(int i = 2; i <= n; i++) {
            log[i] = log[i/2]+1;
        }

        LOG = log[n]+1;
        m1 = new int[n][LOG];
        m2 = new int[n][LOG];

        for(int i = 0; i < n; i++) {
            m1[i][0] = a[i];
            m2[i][0] = a[i];
        }

        // 2. preprocessing, O(N*log(N))
        for(int k = 1; k < LOG; k++) {
            for(int i = 0; i + (1 << k) - 1 < n; i++) {
                m1[i][k] = Math.min(m1[i][k-1], m1[i+(1<<(k-1))][k-1]);
                m2[i][k] = Math.max(m2[i][k-1], m2[i+(1<<(k-1))][k-1]);
            }
        }
    }

    // O(1)
    int query(int L, int R) { // O(1)
        int length = R - L + 1;
        int k = log[length];
        return Math.max(m2[L][k], m2[R-(1<<k)+1][k]) - Math.min(m1[L][k], m1[R-(1<<k)+1][k]);
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        // Instantiate the Sparse Table DS
        SparseTable st = new SparseTable(nums, n);

        // store hash of indices
        Set<String> set = new HashSet<>();

        pq.add(new int[]{st.query(0, n-1), 0, n-1});

        long ans = 0L;
        while(k-- > 0){
            int[] curr = pq.poll();
            int val = curr[0];
            int l = curr[1], r = curr[2];

            ans += val;

            if(l+1 <= r){
                String idx = (l+1) + "$" + r;
                if(!set.contains(idx)){
                    pq.add(new int[]{st.query(l+1, r), l+1, r});
                    set.add(idx);
                }
            }

            if(r-1 >= l){
                String idx = l + "$" + (r-1);
                if(!set.contains(idx)){
                    pq.add(new int[]{st.query(l, r-1), l, r-1});
                    set.add(idx);
                }
            }
        }

        return ans;
    }
}
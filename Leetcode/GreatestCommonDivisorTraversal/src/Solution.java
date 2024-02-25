import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private class DSU {
        private int[] par;
        private int[] siz;

        DSU(int n) {
            init(n);
        }

        void init(int n) {
            par = new int[n];
            siz = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                siz[i] = 1;
            }
        }

        int find(int x) {
            while (x != par[x]) x = par[x];
            return x;
        }


        boolean merge(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            siz[x] += siz[y];
            par[y] = x;
            return true;
        }

        boolean isConnected() {
            return siz[find(0)] == siz.length;
        }
    }

    // get all prime factors of num
    private List<Integer> getPrimes(int num) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i <= num; ++i) {
            if (num % i != 0) continue;
            primes.add(i);
            while ((num % i) == 0) {
                num /= i;
            }
        }
        if (num != 1) primes.add(num);
        return primes;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        // edge case
        if (n == 1) return true;

        DSU dsu = new DSU(n);
        Map<Integer, Integer> vis = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            // edge case
            if (nums[i] == 1) return false;

            //get all prime factors of nums[i]
            List<Integer> primes = getPrimes(nums[i]);
            for (int e : primes) {
                if (vis.containsKey(e)) dsu.merge(vis.get(e), i);
                else vis.put(e, i);
            }
        }
        return dsu.isConnected();
    }
}
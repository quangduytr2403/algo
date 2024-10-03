import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] sumDiv = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) sumDiv[i] = nums[i] % p;
            else sumDiv[i] = (sumDiv[i - 1] + nums[i]) % p;

            if (!map.containsKey(sumDiv[i])) map.put(sumDiv[i], new ArrayList<>());
            map.get(sumDiv[i]).add(i);
        }

        if (sumDiv[n - 1] == 0) return 0;
        int numDiv = sumDiv[n - 1];

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (sumDiv[i] == numDiv) res = Math.min(res, i + 1);
        }

        for (int i = 0; i < n; i++) {
            int nextDiv = (sumDiv[i] + numDiv) % p;

            if (map.containsKey(nextDiv)) {
                res = Math.min(res, map.get(nextDiv).get(0) - i);
            }

            map.get(sumDiv[i]).remove(0);
            if (map.get(sumDiv[i]).isEmpty()) map.remove(sumDiv[i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubarray(new int[]{3,1,4,2}, 6));
    }
}
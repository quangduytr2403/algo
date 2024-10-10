import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Map<Integer, Integer[]> m = new TreeMap<>();
        int minIndex = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!m.containsKey(num)) m.put(num, new Integer[]{i, i});
            else {
                m.get(num)[0] = Math.min(m.get(num)[0], i);
                m.get(num)[1] = Math.max(m.get(num)[1], i);
            }
        }

        for (var entry : m.entrySet()) {
            Integer[] val = entry.getValue();

            res = Math.max(res, val[1] - val[0]);
            if (minIndex != Integer.MAX_VALUE && val[1] > minIndex) {
                res = Math.max(res, val[1] - minIndex);
            }

            minIndex = Math.min(minIndex, val[0]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }
}
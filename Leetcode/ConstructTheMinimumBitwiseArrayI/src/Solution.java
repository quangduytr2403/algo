import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            res[i] = -1;
            for (int j = 1; j <= 1000; j++) {
                if ((j | (j + 1)) == nums.get(i)) {
                    res[i] = j;
                    break;
                }
            }
        }

        return res;
    }
}
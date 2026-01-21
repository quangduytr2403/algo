import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        String binaryString, tmp;
        boolean found;
        int tmpNum;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                res[i] = -1;
                continue;
            }

            found = false;
            binaryString = Integer.toBinaryString(nums.get(i));
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1');
                tmp = binaryString.substring(0, j) + '0' + binaryString.substring(j + 1);
                tmpNum = Integer.parseInt(tmp, 2);
                if ((tmpNum | (tmpNum + 1)) == nums.get(i)) {
                    res[i] = tmpNum;
                    found = true;
                    break;
                }
            }

            if (!found) res[i] = -1;
        }

        return res;
    }
}
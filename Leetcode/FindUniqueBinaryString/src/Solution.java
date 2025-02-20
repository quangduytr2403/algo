import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        Set<String> s = new HashSet<>(List.of(nums));
        if (gen(res, s, nums.length, 0)) return res.toString();

        return "";
    }

    public boolean gen (StringBuilder res, Set<String> s, int n, int index) {
        if (index == n) {
            if (!s.contains(res.toString())) return true;
            return false;
        }
        res.append('0');
        if (gen(res, s, n, index + 1)) return true;
        res.setLength(res.length() - 1);


        res.append('1');
        if (gen(res, s, n, index + 1)) return true;
        res.setLength(res.length() - 1);

        return false;
    }
}
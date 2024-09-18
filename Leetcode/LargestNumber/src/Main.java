import java.util.ArrayList;
import java.util.List;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>();
        for (int num : nums) numStrings.add("" + num);
        numStrings.sort(this::compareStr);
        String res = "";
        for (String numString : numStrings) res += numString;
        while (!res.isEmpty() && res.charAt(0) == '0') res = res.substring(1);
        if ("".equals(res)) res = "0";
        return res;
    }

    private int compareStr(String a, String b) {
        String ab = a + b;
        String ba = b + a;
        return ba.compareTo(ab);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{0, 0}));
    }
}
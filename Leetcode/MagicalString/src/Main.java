
class Solution {
    public int magicalString(int n) {
        if (n <= 3) return 1;
        String s = "122";
        int i = 2;
        int current = 2;
        int res = 1;
        while (i < n) {
            if (s.charAt(i) == '1') s += (3 - current);
            else s = s + (3 - current) + (3 - current);
            current = 3 - current;
            if (s.charAt(i) == '1') res++;
            i++;
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(6));
    }
}
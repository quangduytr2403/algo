class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        int count;
        int div = 0;

        for (int num : nums) {
            count = 0;

            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    count++;
                    div = j;
                }
                if (num % j == 0 && j * j != num) count++;
                if (count > 2) break;
            }

            if (count == 2) res += (1 + num + div + num / div);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumFourDivisors(new int[]{83521}));
    }
}
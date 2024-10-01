class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] div = new int[k];

        for (int i : arr) {
            int d = i % k;
            System.out.println(d);
            div[d > 0 ? d : (d + k) % k]++;
        }
        boolean can = true;
        for (int i = 0; i <= k /2; i++) {
            if (i == 0 || (i == k / 2 && 2 * i == k)) {
                if (div[i] % 2 == 1) {
                    can = false;
                    break;
                }
            } else {
                if (div[i] != div[k - i]) {
                    can = false;
                    break;
                }
            }
        }
        return can;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
    }
}
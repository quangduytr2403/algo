class Solution {
    public int countPermutations(int[] complexity) {
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) return 0;
        }

        long res = 1;
        for (int i = 1; i < complexity.length; i++) {
            res = (res * i) % 1000000007;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPermutations(new int[]{38,223,100,123,406,234,256,93,222,259,233,69,139,245,45,98,214}));
    }
}
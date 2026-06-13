class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";
        int sum;
        for (String w : words) {
            sum = 0;
            for (int i = 0; i < w.length(); i++) {
                sum += weights[w.charAt(i) - 'a'];
            }

            sum = sum % 26;
            res += (char)(25 - sum + 'a');
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mapWordWeights(new String[]{"abcd","def","xyz"}, new int[]{5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2}));
    }
}
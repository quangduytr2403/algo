class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String o : operations) {
            if (o.contains("+")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
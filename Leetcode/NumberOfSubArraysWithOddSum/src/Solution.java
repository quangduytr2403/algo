class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int numOdd = 0;
        int numEven = 1;

        for (int a : arr) {
            sum += a;
            if (sum % 2 == 0) numEven++;
            else numOdd++;
        }

        return (int) ((((long) numOdd) * ((long) numEven)) % 1000000007);
    }
}
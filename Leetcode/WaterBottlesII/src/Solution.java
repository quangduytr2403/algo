class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        int emptyBot = 0;

        while(emptyBot >= numExchange || numBottles > 0) {
            if (numBottles > 0) {
                res += numBottles;
                emptyBot += numBottles;
                numBottles = 0;
            } else {
                emptyBot -= numExchange;
                numBottles++;
                numExchange++;
            }
        }

        return res;
    }
}
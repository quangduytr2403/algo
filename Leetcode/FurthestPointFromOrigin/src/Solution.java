class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cL = 0, cR = 0, cD = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L': {
                    cL ++;
                    break;
                }
                case 'R': {
                    cR++;
                    break;
                }
                default: cD++;
            }
        }

        return cD + Math.max(cL, cR) - Math.min(cL, cR);
    }
}
class Solution {
    public int countCollisions(String directions) {
        char last = 'N';
        int countR = 0;
        int res = 0;
        char c;

        for (int i = 0; i < directions.length(); i++) {
            c = directions.charAt(i);
            if (c == 'S') {
                if (last == 'R') {
                    res += countR;
                }
                last = 'S';
            } else if (c == 'L') {
                if (last == 'R') {
                    res += 2;
                    res += (countR - 1);
                    last = 'S';
                } else if (last == 'S') {
                    res += 1;
                    last = 'S';
                }
            } else {
                if (last != 'R') countR = 1;
                else countR++;

                last = 'R';
            }
        }

        return res;
    }
}
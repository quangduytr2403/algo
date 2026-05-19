class Solution {
    public int romanToInt(String s) {
        int cur = 0;
        int res = 0;
        while (cur < s.length()) {
            switch (s.charAt(cur)) {
                case 'I': {
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'V') {
                        res += 4;
                        cur++;
                        break;
                    }
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'X') {
                        res += 9;
                        cur++;
                        break;
                    }
                    res += 1;
                    break;
                }
                case 'V': {
                    res += 5;
                    break;
                }
                case 'X': {
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'L') {
                        res += 40;
                        cur++;
                        break;
                    }
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'C') {
                        res += 90;
                        cur++;
                        break;
                    }

                    res += 10;
                    break;
                }
                case 'L': {
                    res += 50;
                    break;
                }
                case 'C': {
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'D') {
                        res += 400;
                        cur++;
                        break;
                    }
                    if (cur < s.length() - 1 && s.charAt(cur + 1) == 'M') {
                        res += 900;
                        cur++;
                        break;
                    }

                    res += 100;
                    break;
                }
                case 'D': {
                    res += 500;
                    break;
                }
                default: res += 1000;
            }

            cur++;
        }

        return res;
    }
}
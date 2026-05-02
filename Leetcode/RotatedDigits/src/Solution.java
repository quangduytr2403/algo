class Solution {
    public int rotatedDigits(int n) {
        int res = 0;
        String s;
        StringBuilder sb;

        for (int i = 1; i <= n; i++) {
            s = Integer.toString(i);
            if (s.contains("4") || s.contains("3") || s.contains("7")) continue;
            sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case '2': {
                        sb.append('5');
                        break;
                    }
                    case '5': {
                        sb.append('2');
                        break;
                    }
                    case '6': {
                        sb.append('9');
                    }
                    case '9': {
                        sb.append('6');
                        break;
                    }
                    default:
                        sb.append(s.charAt(j));
                }
            }

            if (!sb.toString().equals(s)) res++;
        }

        return res;
    }
}
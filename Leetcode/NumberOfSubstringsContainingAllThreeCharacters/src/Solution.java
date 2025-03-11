class Solution {
    // Binary search
    public int numberOfSubstrings(String s) {
        int[] sumA = new int[s.length()];
        int[] sumB = new int[s.length()];
        int[] sumC = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            sumA[i] = i > 0 ? sumA[i - 1] : 0;
            sumB[i] = i > 0 ? sumB[i - 1] : 0;
            sumC[i] = i > 0 ? sumC[i - 1] : 0;
            if (s.charAt(i) == 'a') {
                sumA[i]++;
            } else if (s.charAt(i) == 'b') {
                sumB[i]++;
            } else {
                sumC[i]++;
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = find(0, i - 1, sumA, sumB, sumC, i);
            System.out.println(i + " " + index);
            if (index != -1) res += (index + 1);
        }

        return res;
    }

    public int find(int l, int r, int[] sumA, int[] sumB, int[] sumC, int index) {
        if (l >= r - 1) {
            for (int j = r; j >= l; j--) {
                if (check(j, sumA, sumB, sumC, index)) return j;
            }
            return -1;
        }

        int m = (l + r) / 2;
        if (check(m, sumA, sumB, sumC, index)) return find(m, r, sumA, sumB, sumC, index);
        else return find(l, m - 1, sumA, sumB, sumC, index);
    }

    public boolean check(int i, int[] sumA, int[] sumB, int[] sumC, int index) {
        if (sumA[index] - (i > 0 ? sumA[i - 1] : 0) < 1) return false;
        if (sumB[index] - (i > 0 ? sumB[i - 1] : 0) < 1) return false;
        if (sumC[index] - (i > 0 ? sumC[i - 1] : 0) < 1) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
    }
}
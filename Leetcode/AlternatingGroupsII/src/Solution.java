class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < colors.length + k - 1; i++) {
            count++;
            if (colors[i % colors.length] == colors[(i + 1) % colors.length] || i == colors.length + k - 2) {
                if (count >= k) res += (count - k + 1);
                count = 0;
            }
        }

        return res;
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0;
        int p2 = 0;
        List<Integer[]> l = new ArrayList<>();

        while (p1 < nums1.length || p2 < nums2.length) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1][0] == nums2[p2][0]) {
                    l.add(new Integer[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]});
                    p1++;
                    p2++;
                }
                else if (nums1[p1][0] < nums2[p2][0]) {
                    l.add(new Integer[]{nums1[p1][0], nums1[p1][1]});
                    p1++;
                }
                else {
                    l.add(new Integer[]{nums2[p2][0], nums2[p2][1]});
                    p2++;
                }
            } else if (p1 < nums1.length) {
                l.add(new Integer[]{nums1[p1][0], nums1[p1][1]});
                p1++;
            } else {
                l.add(new Integer[]{nums2[p2][0], nums2[p2][1]});
                p2++;
            }
        }

        int[][] res = new int[l.size()][2];

        for (int i = 0; i < l.size(); i++) {
            res[i][0] = l.get(i)[0];
            res[i][1] = l.get(i)[1];
        }

        return res;
    }
}
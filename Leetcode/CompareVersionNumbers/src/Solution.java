import java.util.Arrays;

class Solution {
    public int compareVersion(String version1, String version2) {
        Integer[] v1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] v2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);

        int pt = 0;
        while (pt < v1.length || pt < v2.length) {
            Integer v1Val = pt >= v1.length ? 0 : v1[pt];
            Integer v2Val = pt >= v2.length ? 0 : v2[pt];
            if (v1Val < v2Val) return -1;
            if (v1Val > v2Val) return 1;
            pt++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.2", "1.10"));
    }
}
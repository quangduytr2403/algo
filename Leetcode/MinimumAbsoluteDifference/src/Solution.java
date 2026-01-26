import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] <= min) {
                if (arr[i + 1] - arr[i] < min) {
                    min = arr[i + 1] - arr[i];
                    res = new ArrayList<>();
                }

                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return res;
    }
}
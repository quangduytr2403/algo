import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // This function checks if the given array can be rearranged into an arithmetic sequence.
    private static boolean check(int[] arr) {
        // Sort the array in ascending order.
        Arrays.sort(arr);

        // Calculate the common difference between consecutive elements.
        int diff = arr[1] - arr[0];

        // Check if the differences between consecutive elements are consistent.
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != diff) {
                return false;
            }
        }
        return true;
    }

    // This function processes queries to determine if corresponding subarrays can be rearranged into arithmetic sequences.
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // Get the number of queries.
        int q_count = l.length;
        // Initialize a list to store the results.
        List<Boolean> ans = new ArrayList<>();

        // Iterate through each query.
        for(int i = 0; i < q_count; i++) {
            int left = l[i];
            int right = r[i];
            int length = right - left + 1;

            // Extract the subarray from nums based on the current query.
            int arr[] = new int[length];
            for(int k = 0, m = left; k < length && m <= right; k++, m++) {
                arr[k] = nums[m];
            }

            // Check if the subarray can be rearranged into an arithmetic sequence and add the result to the list.
            ans.add(check(arr));
        }

        // Return the final list of results.
        return ans;
    }
}
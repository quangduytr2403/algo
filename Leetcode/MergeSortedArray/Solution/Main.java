class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1, curr1 = m - 1, curr2 = n - 1;
        while (curr >= 0) {
            if (curr1 < 0 || (curr2 >= 0 && nums1[curr1] <= nums2[curr2])) {
                nums1[curr] = nums2[curr2--];
            } else {
                nums1[curr] = nums1[curr1--];
            }
            curr--;
        }
    }
}
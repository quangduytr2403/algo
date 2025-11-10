import java.util.Stack;

class Solution {
    public int minOperations(int[] nums) {
        var stack = new Stack<Integer>();
        var ans = 0;
        for (var i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
                ans++;
            }
            if ((stack.isEmpty() || stack.peek() != nums[i]) && nums[i] != 0)
                stack.add(nums[i]);
        }
        return ans + stack.size();
    }
}
class TreeNode {
   int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
 }
class Solution {
    boolean check = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return check;
    }

    int dfs(TreeNode root, int height) {
        if (root == null) return 0;

        int left = dfs(root.left, height + 1);
        int right = dfs(root.right, height + 1);

        if (Math.abs(left - right) > 1) check = false;

        return Math.max(left, right) + 1;
    }
}
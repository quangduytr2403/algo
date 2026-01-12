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
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        dfs(root, targetSum, 0);
        return res;
    }

    void dfs(TreeNode node, int targetSum, int currentSum) {
        currentSum += node.val;
        if (node.right == null && node.left == null) {
            if (targetSum == currentSum) {
                res = true;
            }
        } else {
            if (node.left != null) dfs(node.left, targetSum, currentSum);
            if (node.right != null) dfs(node.right, targetSum, currentSum);
        }
    }
}
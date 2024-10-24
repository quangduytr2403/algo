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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return travel(root1, root2);
    }

    public boolean travel(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        int root1LeftVal = root1.left != null ? root1.left.val : -1;
        int root1RightVal = root1.right != null ? root1.right.val : -1;
        int root2LeftVal = root2.left != null ? root2.left.val : -1;
        int root2RightVal = root2.right != null ? root2.right.val : -1;

        if ((root1LeftVal == root2LeftVal && root1RightVal == root2RightVal) ||
                (root1LeftVal == root2RightVal && root1RightVal == root2LeftVal)) {
            if (root1LeftVal == root2RightVal) {
                TreeNode t = root1.left;
                root1.left = root1.right;
                root1.right = t;
            }

            boolean leftTrue = true;
            if (root1.left != null && root2.left != null) leftTrue = travel(root1.left, root2.left);

            boolean rightTrue = true;
            if (root1.right != null && root2.right != null) rightTrue = travel(root1.right, root2.right);

            return leftTrue && rightTrue;
        } else return false;
    }
}
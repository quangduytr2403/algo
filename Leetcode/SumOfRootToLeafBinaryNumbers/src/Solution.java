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
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    void dfs(TreeNode n, String s) {
        if (n.left == null && n.right == null) {
            s += n.val;
            res += Integer.parseInt(s, 2);
            return;
        }

        if (n.left != null) {
            dfs(n.left, s + n.val);
        }

        if (n.right != null) {
            dfs(n.right, s + n.val);
        }
    }
}
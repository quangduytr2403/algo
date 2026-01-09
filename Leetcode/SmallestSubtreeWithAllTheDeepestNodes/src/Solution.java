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
    int maxLevel = 0;
    int countMaxLevel = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        dfs2(root, 0);
        return res;
    }

    void dfs(TreeNode node, int level) {
        if (node != null) {
            level++;
            if (level > maxLevel) {
                maxLevel = level;
                countMaxLevel = 1;
            } else if (level == maxLevel) countMaxLevel++;
            dfs(node.left, level);
            dfs(node.right, level);
        }
    }

    int dfs2(TreeNode node, int level) {
        if (node != null) {
            level++;
            if (level == maxLevel) {
                if (countMaxLevel == 1 && res == null) res = node;
                return 1;
            }

            int sum = dfs2(node.left, level) + dfs2(node.right, level);
            if (countMaxLevel == sum && res == null) res = node;
            return sum;
        }

        return 0;
    }
}
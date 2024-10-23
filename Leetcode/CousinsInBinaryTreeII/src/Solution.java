import java.util.ArrayList;
import java.util.List;

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
    List<Integer> sum = new ArrayList<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        calcSum(root, 0);
        travel(root, 0, 0);
        return root;
    }

    public void calcSum(TreeNode root, int level) {
        if (sum.size() <= level) sum.add(root.val);
        else sum.set(level, sum.get(level) + root.val);

        if (root.left != null) calcSum(root.left, level + 1);
        if (root.right != null) calcSum(root.right, level + 1);
    }

    public void travel(TreeNode root, int level, int sameParentVal) {
        root.val = sum.get(level) - sameParentVal - root.val;

        int rootRightVal = root.right != null ? root.right.val : 0;
        int rootLeftVal = root.left != null ? root.left.val : 0;

        if (root.left != null) travel(root.left, level + 1, rootRightVal);
        if (root.right != null) travel(root.right, level + 1, rootLeftVal);
    }
}
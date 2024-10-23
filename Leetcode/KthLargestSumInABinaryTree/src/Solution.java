import java.util.ArrayList;
import java.util.Comparator;
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
    List<Long> sum = new ArrayList<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        travel(root, 0);
        sum.sort(Comparator.reverseOrder());

        return sum.size() < k ? -1 : sum.get(k - 1);
    }

    public void travel(TreeNode root, int level) {
        if (sum.size() <= level) sum.add((long) root.val);
        else sum.set(level, sum.get(level) + root.val);

        if (root.left != null) travel(root.left, level + 1);
        if (root.right != null) travel(root.right, level + 1);
    }
}
import java.util.HashSet;
import java.util.Set;

public class TreeNode {
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

class FindElements {
    Set<Integer> s = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        s.add(0);
        gen(root);
    }

    public boolean find(int target) {
        return s.contains(target);
    }

    public void gen(TreeNode n) {
        if (n.left != null) {
            n.left.val = 2 * n.val + 1;
            s.add(n.left.val);
            gen(n.left);
        }

        if (n.right != null) {
            n.right.val = 2 * n.val + 2;
            s.add(n.right.val);
            gen(n.right);
        }
    }
}
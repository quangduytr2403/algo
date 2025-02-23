import java.util.Arrays;

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

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        build(preorder, postorder, root);
        return root;
    }

    public void build(int[] preorder, int[] postorder, TreeNode root) {
        if (preorder.length != 1) {
            if (preorder[1] == postorder[postorder.length - 2]) {
                TreeNode newNode = new TreeNode(preorder[1]);
                root.left = newNode;
                build(
                    Arrays.copyOfRange(preorder, 1, preorder.length),
                    Arrays.copyOfRange(postorder, 0, postorder.length - 1),
                    newNode
                );
            } else {
                TreeNode newNodeLeft = new TreeNode(preorder[1]);
                TreeNode newNodeRight = new TreeNode(postorder[postorder.length - 2]);
                root.left = newNodeLeft;
                root.right = newNodeRight;

                int idx = -1;
                for (int i = 0; i < postorder.length; i++) {
                    if (postorder[i] == preorder[1]) {
                        idx = i;
                    }
                }
                build(
                    Arrays.copyOfRange(preorder, 1, idx + 2),
                    Arrays.copyOfRange(postorder, 0, idx + 1),
                    newNodeLeft
                );
                build(
                    Arrays.copyOfRange(preorder, idx + 2, preorder.length),
                    Arrays.copyOfRange(postorder, idx + 1, postorder.length - 1),
                    newNodeRight
                );
            }
        }
    }
}
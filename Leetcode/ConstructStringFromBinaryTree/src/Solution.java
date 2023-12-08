
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    StringBuilder ans = new StringBuilder(); // StringBuilder to store the final string representation

    // Helper function to perform preorder traversal of the tree and construct the string
    public void pre(TreeNode root) {
        if (root == null) {
            return; // Base case: If the node is null, return
        }

        // Append the current node's value to the StringBuilder
        ans.append(root.val);

        // If the current node has a left child or a right child, include parentheses
        if (root.left != null || root.right != null) {
            ans.append("(");
            pre(root.left); // Recursive call to process the left subtree
            ans.append(")");
        }

        // If the current node has a right child, include parentheses
        if (root.right != null) {
            ans.append("(");
            pre(root.right); // Recursive call to process the right subtree
            ans.append(")");
        }
    }

    // Main function to convert the binary tree to the required string format
    public String tree2str(TreeNode root) {
        pre(root); // Call the helper function to construct the string
        return ans.toString(); // Return the final string representation of the tree
    }
}

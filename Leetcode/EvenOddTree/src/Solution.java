import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> main = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        main.add(root);
        int level = 0;
        int prevVal = -1;

        while (!main.isEmpty()) {
            while (!main.isEmpty()) {
                TreeNode node = main.poll();
                if ((level % 2 == 0 && node.val % 2 == 0) || (level % 2 == 1 && node.val % 2 == 1)) return false;
                if (prevVal != -1 && ((node.val <= prevVal && level % 2 == 0) || (node.val >= prevVal && level % 2 == 1))) return false;

                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
                prevVal = node.val;
            }
            level++;
            prevVal = -1;
            main = tmp;
            tmp = new LinkedList<>();
        }

        return true;
    }
}
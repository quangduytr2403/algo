import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> m = new HashMap<>();
        Set<Integer> haveParent = new HashSet<>();

        for (int[] d : descriptions) {
            if (!m.containsKey(d[0])) m.put(d[0], new TreeNode(d[0]));
            if (!m.containsKey(d[1])) m.put(d[1], new TreeNode(d[1]));
            haveParent.add(d[1]);
            if (d[2] == 1) m.get(d[0]).left = m.get(d[1]);
            else m.get(d[0]).right = m.get(d[1]);
        }

        for (Integer i : m.keySet()) {
            if (!haveParent.contains(i)) return m.get(i);
        }

        return null;
    }
}
import java.util.Stack;

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

class Tuple {
    TreeNode node;
    int level;

    public Tuple(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }
}

class Solution {
    Stack<Tuple> st = new Stack<>();
    public TreeNode recoverFromPreorder(String traversal) {
        // Dummy end
        traversal += '-';
        int currentNum = 0;
        int currentLevel = 0;
        int prevLevel = -1;
        TreeNode root = null;
        for (int i = 0; i < traversal.length(); i++) {
            if (traversal.charAt(i) != '-') {
                currentNum = currentNum * 10 + Integer.parseInt("" + traversal.charAt(i));
            } else {
                if (traversal.charAt(i - 1) == '-') currentLevel++;
                else {
                    if (currentLevel != prevLevel + 1) {
                        while (true) {
                            Tuple t = st.pop();
                            if (t.getLevel() == currentLevel) {
                                TreeNode newNode = new TreeNode(currentNum);
                                Tuple tp = st.peek();
                                tp.getNode().right = newNode;
                                st.add(new Tuple(newNode, currentLevel));
                                break;
                            }
                        }
                    } else {
                        TreeNode newNode = new TreeNode(currentNum);
                        if (currentLevel == 0) {
                            root = newNode;
                        } else {
                            Tuple tp = st.peek();
                            tp.getNode().left = newNode;
                        }
                        st.add(new Tuple(newNode, currentLevel));
                    }
                    prevLevel = currentLevel;
                    currentNum = 0;
                    currentLevel = 1;
                }
            }
        }

        return root;
    }
}
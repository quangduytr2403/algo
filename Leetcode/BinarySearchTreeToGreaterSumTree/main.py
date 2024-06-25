# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.sum = 0


    def bstToGst(self, root):
        if root:
            self.bstToGst(root.right)  # Traverse the right subtree
            self.sum += root.val  # Update the sum
            root.val = self.sum  # Update the current node's value
            self.bstToGst(root.left)  # Traverse the left subtree
        return root


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    pass

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

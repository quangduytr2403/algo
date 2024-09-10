# This is a sample Python script.
import math
from typing import Optional


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node = head
        while node.next is not None:
            val1 = node.val
            val2 = node.next.val
            gcd = math.gcd(val1, val2)
            new_node = ListNode(gcd, node.next)
            node.next = new_node
            node = node.next.next

        return head

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

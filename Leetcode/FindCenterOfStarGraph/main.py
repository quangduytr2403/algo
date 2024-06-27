# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        if edges[0][0] == edges[1][0]:
            return edges[0][0]
        if edges[0][0] == edges[1][1]:
            return edges[0][0]
        return edges[0][1]




# See PyCharm help at https://www.jetbrains.com/help/pycharm/

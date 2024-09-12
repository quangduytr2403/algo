# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        res = 0
        for word in words:
            check = True
            for c in word:
                if c not in allowed:
                    check = False
                    break
            if check:
                res += 1
        return res
# See PyCharm help at https://www.jetbrains.com/help/pycharm/

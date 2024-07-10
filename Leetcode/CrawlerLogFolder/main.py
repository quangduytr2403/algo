# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def minOperations(self, logs: List[str]) -> int:
        res = 0
        for str in logs:
            if str == "../":
                if res != 0:
                    res -= 1
            elif str != "./":
                res += 1
        return res



# See PyCharm help at https://www.jetbrains.com/help/pycharm/

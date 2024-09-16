# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        res = 99999
        n = len(timePoints)
        convert = []
        for timePoint in timePoints:
            convert.append(int(timePoint[0:2]) * 60 + int(timePoint[3:5]))
        convert.sort()
        prev = convert[n - 1]
        for c in convert:
            res = min(res, min(abs(c - prev), 1440 - abs(c - prev)))
            prev = c
        return res


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.findMinDifference(["01:01","02:01"]))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

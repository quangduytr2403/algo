# This is a sample Python script.
import math


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        return bin(start ^ goal).count("1")


if __name__ == "__main__":
    solution = Solution()
    print(solution.minBitFlips(10, 7))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

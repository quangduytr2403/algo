# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        maxBitwiseAnd = max(nums)
        maxi = 1
        count = 0
        i = 0

        while i < len(nums):
            if nums[i] == maxBitwiseAnd:
                while i < len(nums) and nums[i] == maxBitwiseAnd:
                    count += 1
                    i += 1
                maxi = max(maxi, count)
                count = 0
            else:
                i += 1

        return maxi

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.longestSubarray([1,2,3,3,2,999999]))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

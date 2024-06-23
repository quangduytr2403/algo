# This is a sample Python script.
from collections import deque
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def adjust(self, mono, left):
        while mono and mono[0][1] < left:
            mono.popleft()

    def longestSubarray(self, nums: List[int], limit: int) -> int:
        ans = 0
        # Contain decrease order
        monoMax = deque()
        # Contain increase order
        monoMin = deque()

        j = 0
        for i in range(len(nums)):
            while monoMax and nums[i] > monoMax[-1][0]:
                monoMax.pop()
            while monoMin and nums[i] < monoMin[-1][0]:
                monoMin.pop()

            monoMin.append((nums[i], i))
            monoMax.append((nums[i], i))

            print("Min", monoMin)
            print("Max", monoMax)

            while True:
                print("j", j)
                self.adjust(monoMin, j)
                self.adjust(monoMax, j)
                if monoMax[0][0] - monoMin[0][0] > limit:
                    j += 1
                else:
                    break

            print("Min", monoMin)
            print("Max", monoMax)

            # Assume current elements is end of substring
            ans = max(ans, i - j + 1)

        return ans


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    nums = [10, 1, 2, 4, 7, 2]
    limit = 5
    result = Solution().longestSubarray(nums, limit)
    print("The length of the longest subarray is:", result)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

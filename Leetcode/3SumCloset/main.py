# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def binary(self, start: int, end: int, nums: List[int], target: int) -> int:
        if start >= end - 1:
            if nums[start] >= target:
                return start
            else:
                if nums[end] <= target:
                    return end
                else:
                    return start

        mid = (start + end) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            return self.binary(start, mid - 1, nums, target)
        else:
            return self.binary(mid, end, nums, target)

    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        closest = float('inf')
        result = None

        for i in range(len(nums) - 2):
            for j in range(i + 1, len(nums) - 1):
                index = self.binary(j + 1, len(nums) - 1, nums, target - nums[i] - nums[j])
                current_sum = nums[i] + nums[j] + nums[index]
                if abs(target - current_sum) < closest:
                    closest = abs(target - current_sum)
                    result = current_sum

                if index < len(nums) - 1:
                    current_sum = nums[i] + nums[j] + nums[index + 1]
                    if abs(target - current_sum) < closest:
                        closest = abs(target - current_sum)
                        result = current_sum

        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
   s = Solution()
   print(s.threeSumClosest([-1,2,1,-4], 1))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

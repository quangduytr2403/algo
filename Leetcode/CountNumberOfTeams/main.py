# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def numTeams(self, rating: List[int]) -> int:
        insertion = [rating[len(rating) - 1]]
        num_of_greater = [0]
        num_of_smaller = [0]
        res = 0

        for r in rating[-2::-1]:
            greater = 0
            smaller = 0
            inserted = False

            for i, val in enumerate(insertion):
                if val > r:
                    greater += 1
                else:
                    smaller = len(insertion) - greater
                    insertion.insert(i, r)
                    inserted = True
                    break
            if not inserted:
                insertion.append(r)
            num_of_greater.insert(0, greater)
            num_of_smaller.insert(0, smaller)

        for (i, r) in enumerate(rating):
            for j in range(i + 1, len(rating)):
                if r < rating[j]:
                    res += num_of_greater[j]
                elif r > rating[j]:
                    res += num_of_smaller[j]
        return res

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.numTeams([1,2,3,4]))


# See PyCharm help at https://www.jetbrains.com/help/pycharm/

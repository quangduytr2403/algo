# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        books.insert(0, [0, 0])  # dummy book
        dp = [1000001] * len(books)
        dp[0] = 0

        for i in range(1, len(books)):
            print(books[i])
            sum_thick = 0
            cur_height = 0
            j = i
            while j > 0:
                if sum_thick + books[j][0] <= shelfWidth:
                    cur_height = max(cur_height, books[j][1])
                    dp[i] = min(dp[i], dp[j - 1] + cur_height)
                    sum_thick = sum_thick + books[j][0]
                else:
                    break
                j -= 1

        return dp[len(books) - 1]

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.minHeightShelves([[1,3],[2,4],[3,2]], 6))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

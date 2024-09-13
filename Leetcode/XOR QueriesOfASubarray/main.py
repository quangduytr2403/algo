# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        res = []
        sum_xor = []
        for _, i in enumerate(arr):
            if _ == 0:
                sum_xor.append(i)
            else:
                sum_xor.append(sum_xor[len(sum_xor) - 1] ^ i)

        for query in queries:
            if query[0] == 0:
                res.append(sum_xor[query[1]])
            else:
                res.append(sum_xor[query[1]] ^ sum_xor[query[0] - 1])
        return res

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    pass

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

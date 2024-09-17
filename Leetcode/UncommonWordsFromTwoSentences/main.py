# This is a sample Python script.
from collections import Counter
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        s1_dict = Counter(s1.split(" "))
        s2_dict = Counter(s2.split(" "))

        res = []
        for k, v in s1_dict.items():
            if v == 1 and k not in s2_dict:
                res.append(k)
        for k, v in s2_dict.items():
            if v == 1 and k not in s1_dict:
                res.append(k)

        return res
# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.uncommonFromSentences(s1 = "this apple is sweet", s2 = "this apple is sour"))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

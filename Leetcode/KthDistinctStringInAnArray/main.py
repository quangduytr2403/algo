# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        string_dict = {}
        for st in arr:
            if not string_dict.__contains__(st):
                string_dict[st] = 1
            else:
                string_dict[st] += 1

        for s,v in string_dict.items():
            if v == 1:
                k -= 1
            if k == 0:
                return s
        return ""


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

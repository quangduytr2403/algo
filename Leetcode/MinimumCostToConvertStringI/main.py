# This is a sample Python script.
from heapq import heappush, heappop
from typing import List


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        paths = {}
        for orig, chg, c in zip(original, changed, cost):
            orig_index = ord(orig) - 97
            chg_index = ord(chg) - 97
            if orig_index not in paths:
                paths[orig_index] = {}
            paths[orig_index][chg_index] = min(paths[orig_index].get(chg_index, float('inf')), c)

        sum_cost = {i: {} for i in range(26)}
        for i in range(26):
            heap = [(0, i)]
            while heap:
                cur_cost, cur_char = heappop(heap)
                if cur_char in paths:
                    for chg, c in paths[cur_char].items():
                        new_cost = cur_cost + c
                        if chg not in sum_cost[i] or sum_cost[i][chg] > new_cost:
                            sum_cost[i][chg] = new_cost
                            heappush(heap, (new_cost, chg))

        res = 0
        for sc, tc in zip(source, target):
            if sc != tc:
                sc_index = ord(sc) - 97
                tc_index = ord(tc) - 97
                if tc_index not in sum_cost[sc_index]:
                    return -1
                res += sum_cost[sc_index][tc_index]

        return res


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.minimumCost("abcd", "acbe", ["a", "b", "c", "c", "e", "d"],
                               ["b", "c", "b", "e", "b", "e"],
                               [2, 5, 5, 1, 2, 20]))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

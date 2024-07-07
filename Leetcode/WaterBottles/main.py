# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        res = 0
        numCovers = 0
        while True:
            res += numBottles
            numCovers += numBottles
            if numCovers >= numExchange:
                numBottles = numCovers // numExchange
                numCovers -= numBottles * numExchange
            else:
                break

        return res



# See PyCharm help at https://www.jetbrains.com/help/pycharm/

# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        mapy = [-2] * 32
        mapy[0] = -1

        max_len = 0
        mask = 0

        for i, char in enumerate(s):
            if char == 'a':
                mask ^= 1
            elif char == 'e':
                mask ^= 2
            elif char == 'i':
                mask ^= 4
            elif char == 'o':
                mask ^= 8
            elif char == 'u':
                mask ^= 16

            prev = mapy[mask]
            if prev == -2:
                mapy[mask] = i
            else:
                max_len = max(max_len, i - prev)

        return max_len

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    print(solution.findTheLongestSubstring("eleetminicoworoep"))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

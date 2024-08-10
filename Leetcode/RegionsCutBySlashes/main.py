# This is a sample Python script.
from typing import List


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    visited = []
    p_grid = None
    n = None

    def dfs(self, v):
        (x, y, z) = v
        self.visited[x][y][z] = True
        if z == 0:
            if self.p_grid[x][y] != "/" and not self.visited[x][y][1]:
                self.dfs((x, y, 1))
            if self.p_grid[x][y] != "\\" and not self.visited[x][y][3]:
                self.dfs((x, y, 3))
            if x - 1 >= 0 and not self.visited[x - 1][y][2]:
                self.dfs((x - 1, y, 2))
        elif z == 1:
            if self.p_grid[x][y] != "/" and not self.visited[x][y][0]:
                self.dfs((x, y, 0))
            if self.p_grid[x][y] != "\\" and not self.visited[x][y][2]:
                self.dfs((x, y, 2))
            if y + 1 < self.n and not self.visited[x][y + 1][3]:
                self.dfs((x, y + 1, 3))
        elif z == 2:
            if self.p_grid[x][y] != "/" and not self.visited[x][y][3]:
                self.dfs((x, y, 3))
            if self.p_grid[x][y] != "\\" and not self.visited[x][y][1]:
                self.dfs((x, y, 1))
            if x + 1 < self.n and not self.visited[x + 1][y][0]:
                self.dfs((x + 1, y, 0))
        elif z == 3:
            if self.p_grid[x][y] != "/" and not self.visited[x][y][2]:
                self.dfs((x, y, 2))
            if self.p_grid[x][y] != "\\" and not self.visited[x][y][0]:
                self.dfs((x, y, 0))
            if y - 1 >= 0 and not self.visited[x][y - 1][1]:
                self.dfs((x, y - 1, 1))

    def regionsBySlashes(self, grid: List[str]) -> int:
        self.n = len(grid)
        self.p_grid = grid
        self.visited = [[[False for _ in range(4)] for _ in range(self.n)] for _ in range(self.n)]
        res = 0

        for x in range(self.n):
            for y in range(self.n):
                for z in range(4):
                    if not self.visited[x][y][z]:
                        res += 1
                        self.dfs((x, y, z))

        return res


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    solution = Solution()
    solution.regionsBySlashes([" /","/ "])

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

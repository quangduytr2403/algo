# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        def is_connected(grid):
            visited = [[False] * n for _ in range(m)]

            def dfs(x, y):
                visited[x][y] = True
                for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 1:
                        dfs(nx, ny)

            found = False
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1 and not visited[i][j]:
                        if found:
                            return False  # found another island
                        found = True
                        dfs(i, j)
            return found

        def count_islands(grid):
            count = 0
            visited = [[False] * n for _ in range(m)]

            def dfs(x, y):
                visited[x][y] = True
                for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 1:
                        dfs(nx, ny)

            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1 and not visited[i][j]:
                        count += 1
                        dfs(i, j)
            return count

        m, n = len(grid), len(grid[0])

        # If grid is already disconnected
        if count_islands(grid) != 1:
            return 0

        # Try to disconnect by removing one cell
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    if count_islands(grid) != 1:
                        return 1
                    grid[i][j] = 1

        # If we need to remove two cells
        return 2


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    pass

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
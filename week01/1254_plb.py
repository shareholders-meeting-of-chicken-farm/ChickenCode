"""Python3 Code to solve problem 1254: Number of closed islands.
   https://leetcode.com/problems/number-of-closed-islands/
"""


def close_island(grid):
    if not grid or len(grid) == 0:
        return 0

    height, width = len(grid), len(grid[0])

    count = 0

    for x in range(height):
        for y in range(width):
            if grid[x][y] == 0:
                is_island = dfs(grid, x, y)
                if is_island:
                    count += 1

    return count


def dfs(grid, x, y):
    """When find a `0` in the grid, visit all neighbor `0` s and decide whether
    it is an island."""
    height, width = len(grid), len(grid[0])
    is_island = True
    if (x == 0 or x == height - 1) or (y == 0 or y == width - 1):
        is_island = False

    # When visited, set grid[x][y] = -1 to avoid visiting repeatly.
    grid[x][y] = -1

    directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

    for direction in directions:
        new_x = x + direction[0]
        new_y = y + direction[1]
        if (0 <= new_x < height
                and 0 <= new_y < width
                and grid[new_x][new_y] == 0):
            dfs_result = dfs(grid, new_x, new_y)
            is_island = is_island & dfs_result

    return is_island

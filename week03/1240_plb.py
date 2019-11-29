def tilingRectangle(n, m):
    results = [[0] * (m + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if i == 1:
                results[i][j] = j
            elif j == 1:
                results[i][j] = i
            elif i == j:
                results[i][j] = 1
            else:
                minimum = 1e10
                for k in range(1, min(i, j) + 1):
                    current = results[i - k][j] + results[k][j-k] + 1
                    if current < minimum:
                        minimum = current
                results[i][j] = minimum

    return results[n][m]


print(tilingRectangle(11, 13))
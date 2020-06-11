class Solution(object):
    def dieSimulator(self, n, rollMax):
        """
        :type n: int
        :type rollMax: List[int]
        :rtype: int
        """
        # dp[i][j] means number of valid length i sequences end with j
        dp = [[0 for _ in range(6)] for _ in range(n + 1)]
        for j in range(6):
            dp[1][j] = 1

        for i in range(2, n + 1):
            for j in range(6):
                if i <= rollMax[j]:
                    dp[i][j] = sum(dp[i - 1])
                elif i - rollMax[j] == 1:
                    dp[i][j] = sum(dp[i - 1]) - 1
                else:
                    dp[i][j] = sum(dp[i - 1]) - sum(dp[i - rollMax[j] - 1]) + dp[i - rollMax[j] - 1][j]

                dp[i][j] %= (10 ** 9 + 7)

        return sum(dp[-1]) % (10 ** 9 + 7)

import bisect


class Solution(object):
    def jobScheduling(self, startTime, endTime, profit):
        """
        :type startTime: List[int]
        :type endTime: List[int]
        :type profit: List[int]
        :rtype: int
        """
        jobs = sorted(zip(startTime, endTime, profit), key=lambda x: x[1])
        sorted_end_time = [job[1] for job in jobs]
        dp = [0 for _ in range(len(jobs))]
        dp[0] = jobs[0][2]

        for i in range(1, len(jobs)):
            start_i = jobs[i][0]
            profit_i = jobs[i][2]
            last_available = bisect.bisect(sorted_end_time, start_i) - 1
            if last_available >= 0:
                dp[i] = max(dp[last_available] + profit_i, dp[i - 1])
            else:
                dp[i] = max(profit_i, dp[i - 1])
        return dp[-1]

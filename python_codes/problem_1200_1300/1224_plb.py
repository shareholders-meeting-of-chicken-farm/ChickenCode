class Solution(object):
    def maxEqualFreq(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_freq = 0
        num_count = {}
        freq_count = {}  # freq_count[n] means the number of the numbers with appeared n times.

        result = 0

        for i, num in enumerate(nums):
            num_viewed = i + 1
            if num not in num_count:
                num_count[num] = 1
            else:
                num_count[num] += 1

            if num_count[num] > max_freq:
                max_freq = num_count[num]

            if num_count[num] not in freq_count:
                freq_count[num_count[num]] = 1
            else:
                freq_count[num_count[num]] += 1

            if num_count[num] - 1 in freq_count:
                freq_count[num_count[num] - 1] -= 1

            if (max_freq == 1  # Each number appear once.
                or max_freq * freq_count[max_freq] + 1 == num_viewed
                # Each number appear same times and one appear once
                    or ((max_freq - 1) * (freq_count[max_freq - 1] + 1) + 1 == num_viewed)):
                    # One number appears max_freq times, and other appear (max_freq - 1) times
                result = num_viewed

        return result

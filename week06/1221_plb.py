class Solution(object):
    def balancedStringSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        l_count = 0
        r_count = 0
        split_count = 0

        for c in s:
            if c == "R":
                r_count += 1
            else:
                l_count += 1

            if r_count == l_count:
                split_count += 1

        return split_count

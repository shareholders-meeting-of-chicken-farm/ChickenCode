class Solution(object):
    def balancedString(self, s):
        """
        :type s: str
        :rtype: int
        """
        avg = int(len(s) / 4)
        count = {"Q": 0, "W": 0, "E": 0, "R": 0}
        for c in s:
            count[c] += 1

        # Count is the appear time of characters out of the interval.

        left = 0
        result = len(s)

        for right in range(len(s)):
            count[s[right]] -= 1
            while left <= right:
                if count['Q'] <= avg and count['W'] <= avg and count['E'] <= avg and count['R'] <= avg:
                    result = min(result, right - left + 1)
                else:
                    break
                count[s[left]] += 1
                if count['Q'] <= avg and count['W'] <= avg and count['E'] <= avg and count['R'] <= avg:
                    result = min(result, right - left)
                left += 1

        return result


s = Solution()
print(s.balancedString("QWER"))
print(s.balancedString("QQWE"))
print(s.balancedString("QQQW"))
print(s.balancedString("QQQQ"))

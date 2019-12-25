class Solution(object):
    def findSolution(self, customfunction, z):
        """
        :type num: int
        :type z: int
        :rtype: List[List[int]]
        """
        y = 1000
        result = []
        for x in range(1, 1001):
            while customfunction.f(x, y) > z and y > 1:
                y -= 1
            if customfunction.f(x, y) == z:
                result.append((x, y))

        return result

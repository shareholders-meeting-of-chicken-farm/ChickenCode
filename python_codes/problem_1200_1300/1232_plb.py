class Solution(object):
    def checkStraightLine(self, coordinates):
        """
        :type coordinates: List[List[int]]
        :rtype: bool
        """
        if len(coordinates) == 2:
            return True

        p1_x, p1_y = coordinates[0]
        k = None
        straight = False
        result = True

        for point in coordinates[1:]:
            p_x, p_y = point
            if p_x == p1_x and p_y == p1_y:
                continue
            elif p_x == p1_x:
                straight = True
            else:
                if straight:
                    result = False
                    break
                current_k = float(p_y - p1_y) / (p_x - p1_x)
                if k is None:
                    k = current_k
                elif k - current_k > 1e-7 or current_k - k > 1e-7:
                    result = False
                    break
        return result

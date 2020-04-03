class Solution(object):
    def queensAttacktheKing(self, queens, king):
        """
        :type queens: List[List[int]]
        :type king: List[int]
        :rtype: List[List[int]]
        """
        king_x, king_y = king
        result = []

        # left
        for i in range(king_x - 1, -1, -1):
            position = [i, king_y]
            if position in queens:
                result.append(position)
                break

        # right
        for i in range(king_x + 1, 8):
            position = [i, king_y]
            if position in queens:
                result.append(position)
                break

        # up
        for i in range(king_y - 1, -1, -1):
            position = [king_x, i]
            if position in queens:
                result.append(position)
                break

        # down
        for i in range(king_y + 1, 8):
            position = [king_x, i]
            if position in queens:
                result.append(position)
                break

        # diagnal
        while king_x > 0 and king_y > 0:
            king_x -= 1
            king_y -= 1
            if [king_x, king_y] in queens:
                result.append([king_x, king_y])
                break

        king_x, king_y = king
        while king_x < 7 and king_y < 7:
            king_x += 1
            king_y += 1
            if [king_x, king_y] in queens:
                result.append([king_x, king_y])
                break

        king_x, king_y = king
        while king_x > 0 and king_y < 7:
            king_x -= 1
            king_y += 1
            if [king_x, king_y] in queens:
                result.append([king_x, king_y])
                break

        king_x, king_y = king
        while king_x < 7 and king_y > 0:
            king_x += 1
            king_y -= 1
            if [king_x, king_y] in queens:
                result.append([king_x, king_y])
                break

        return result

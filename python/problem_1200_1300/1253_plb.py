"""Python3 Code to solve problem 1253: Reconstruct a 2-Row Binary Matrix. """


class Solution(object):
    def reconstructMatrix(self, upper: int, lower: int, colsum: list) -> list:
        zero_col = set()
        two_col = set()
        col_num = len(colsum)

        for col_id, col_sum in enumerate(colsum):
            if col_sum == 0:
                zero_col.add(col_id)
            elif col_sum == 2:
                two_col.add(col_id)

        one_col_num = col_num - len(zero_col) - len(two_col)
        one_col_upper_num = upper - len(two_col)
        one_col_lower_num = lower - len(two_col)

        if (one_col_upper_num < 0
                or one_col_lower_num < 0
                or one_col_upper_num + one_col_lower_num != one_col_num):
            return []

        result = [[0] * col_num for _ in range(2)]
        one_added_upper_num = 0
        for i in range(col_num):
            if i in zero_col:
                continue
            elif i in two_col:
                result[0][i] = 1
                result[1][i] = 1
            elif one_added_upper_num < one_col_upper_num:
                result[0][i] = 1
                one_added_upper_num += 1
            else:
                result[1][i] = 1

        return result

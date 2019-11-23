class Solution:
    def oddCells(self, n: int, m: int, indices: list) -> int:
        row_operation = [False] * n
        col_operation = [False] * m

        for index in indices:
            row_id, col_id = index
            row_operation[row_id] = not row_operation[row_id]
            col_operation[col_id] = not col_operation[col_id]

        row_operated_num = 0
        col_operated_num = 0

        for op in row_operation:
            if op:
                row_operated_num += 1

        for op in col_operation:
            if op:
                col_operated_num += 1

        return (row_operated_num * m
                + col_operated_num * n
                - 2* row_operated_num * col_operated_num)

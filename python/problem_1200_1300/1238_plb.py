class Solution(object):
    def circularPermutation(self, n, start):
        """
        :type n: int
        :type start: int
        :rtype: List[int]
        """
        n_permute = self.get_n_permute(n)
        base10 = [int(x, 2) for x in n_permute]
        start_index = base10.index(start)

        return base10[start_index:] + base10[:start_index]

    def get_n_permute(self, n):
        if n == 1:
            return ["0", "1"]
        return ["0" + x for x in self.get_n_permute(n - 1)] + ["1" + x for x in self.get_n_permute(n - 1)[::-1]]

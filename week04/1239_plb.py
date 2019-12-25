class Solution(object):
    def maxLength(self, arr):
        """
        :type arr: List[str]
        :rtype: int
        """
        arr = [x for x in arr if len(x) == len(set(x))]

        all_sets = [set()]
        for s in arr:
            s = set(s)
            for prev_set in all_sets:
                if not s.intersection(prev_set):
                    all_sets.append(s.union(prev_set))

        max_length = 0
        for s in all_sets:
            max_length = max(max_length, len(s))

        return max_length

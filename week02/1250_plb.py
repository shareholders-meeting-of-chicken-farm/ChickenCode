class Solution:
    def isGoodArray(self, nums: list) -> bool:
        if len(nums) == 1:
            return nums[0] == 1 or nums[0] == -1
        gcd = compute_gcd(nums[0], nums[1])
        if len(nums) == 2:
            return gcd == 1
        for i in range(1, len(nums) - 1):
            gcd = compute_gcd(gcd, nums[i + 1])
            if gcd == 1:
                return True
        return False


def compute_gcd(x, y):
    """Compute gcd of two positive integers x and y"""
    if x < y:
        return compute_gcd(y, x)

    residual = x % y
    if residual == 0:
        return y
    if residual == 1:
        return 1
    return compute_gcd(y, residual)

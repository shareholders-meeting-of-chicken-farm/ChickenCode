"""Code to solve leetcode problem 1248"""


def numberOfSubarrays(nums, k):
    number_between_odd = []
    count = 0
    for num in nums:
        if num % 2 == 1:
            number_between_odd.append(count)
            count = 0
        else:
            count += 1
    number_between_odd.append(count)

    result = 0
    for i in range(0, len(number_between_odd) - k):
        result += (number_between_odd[i] + 1) * (number_between_odd[i + k] + 1)

    return result


NUMS = [1, 1, 2, 1, 1]
K = 3

print(numberOfSubarrays(NUMS, K))

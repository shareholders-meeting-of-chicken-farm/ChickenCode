"""Code to solve leetcode 1247."""


def minimumSwap(s1, s2):
    x1y2 = 0
    x2y1 = 0
    if len(s1) != len(s2):
        return -1

    for i in range(len(s1)):
        if s1[i] == s2[i]:
            continue
        elif s1[i] == "x":
            x1y2 += 1
        else:
            x2y1 += 1

    # xx, yy -> xy, yx in one step
    count1 = int(x1y2 / 2)
    rest1 = x1y2 % 2

    # yy, xx -> yx, yx
    count2 = int(x2y1 / 2)
    rest2 = x2y1 % 2

    if (rest1 + rest2) % 2 != 0:
        return -1

    if rest1 == 0:
        return count1 + count2

    else:
        # xy, yx -> xx, yy -> xy, xy
        return count1 + count2 + 2

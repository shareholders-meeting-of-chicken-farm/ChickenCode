"""Python3 Code to solve problem 1255: Maximum Score Words Formed by Letters.
   https://leetcode.com/problems/maximum-score-words-formed-by-letters/
"""


def max_score_words(words, letters, score):
    """Brute Force"""
    num_words = len(words)
    word_scores = [0 for _ in range(num_words)]
    letter_used_by_word = [[0] * 26 for _ in range(num_words)]

    letter_count = [0] * 26
    for letter in letters:
        letter_count[ord(letter) - ord("a")] += 1

    for i in range(num_words):
        word = words[i]
        word_score = 0
        for letter in word:
            j = ord(letter) - ord("a")
            word_score += score[j]
            letter_used_by_word[i][j] += 1
        word_scores[i] = word_score

    max_score = 0

    for i in range(2 ** num_words):
        binary_i = "{:b}".format(i)
        zero_need = num_words - len(binary_i)
        binary_i = "0" * zero_need + binary_i

        score = 0
        letter_used = [0] * 26

        for word_index in range(len(binary_i)):
            if binary_i[word_index] == "0":
                continue
            score += word_scores[word_index]
            for j in range(26):
                letter_used[j] += letter_used_by_word[word_index][j]

        plan_ok = True
        for j in range(26):
            if letter_used[j] > letter_count[j]:
                plan_ok = False
                break

        if plan_ok and score > max_score:
            max_score = score

    return max_score

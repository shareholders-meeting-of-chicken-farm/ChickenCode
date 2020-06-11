class Solution:
    def minRemoveToMakeValid(self, s):
        char_stack = []
        index_stack = []

        chars = [c for c in s]

        for i in range(len(chars)):
            if chars[i] == "(":
                char_stack.append(chars[i])
                index_stack.append(i)
            elif chars[i] == ")":
                if char_stack and char_stack[-1] == "(":
                    char_stack.pop()
                    index_stack.pop()
                else:
                    char_stack.append(chars[i])
                    index_stack.append(i)

        for index in index_stack:
            chars[index] = ""

        return "".join(chars)

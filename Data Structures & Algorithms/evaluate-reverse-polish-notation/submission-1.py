class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        result = 0
        for token in tokens:
            if token in "+-*/":
                a = stack.pop()
                b = stack.pop()
                if token == "+":
                    result = b + a
                elif token == "-":
                    result = b - a
                elif token == "*":
                    result = b * a
                else:
                    result = int(b / a)
                stack.append(result)
            else: 
                stack.append(int(token))
        return stack[0]

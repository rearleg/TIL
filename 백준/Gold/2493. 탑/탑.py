import sys

input = sys.stdin.readline

N = int(input())
heights = list(enumerate(map(int, input().split()), start=1))
stack = []
answer = []


for i in range(N):
    # stack이 비어있다면 stack에 heights[i]를 추가하고 answer에 0을 추가

    while len(stack) > 0:
        if stack[-1][1] < heights[i][1]:
            stack.pop()
        elif stack[-1][1] == heights[i][1]:
            answer.append(stack[-1][0])
            stack.pop()
            stack.append(heights[i])
            break
        else:
            answer.append(stack[-1][0])
            stack.append(heights[i])
            break

    if not stack:
        answer.append(0)
        stack.append(heights[i])

print(" ".join(map(str, answer)))
# 1874번 문제 풀어라

import sys

input = sys.stdin.readline

T = int(input())
lst = []
for _ in range(T):
    lst.append(int(input()))

a = 0
n = 1
stack = []
answer = []
cmd = []
while n <= T + 1:
    if len(stack) != 0:
        if stack[-1] == lst[a]:
            answer.append(stack.pop())
            cmd.append("-")
            a += 1
        else:
            stack.append(n)
            cmd.append("+")
            n += 1
    else:
        stack.append(n)
        cmd.append("+")
        n += 1
stack.pop()
if stack:
    print("NO")
else:
    print("\n".join(map(str, cmd[:-1])))

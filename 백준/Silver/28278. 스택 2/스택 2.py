import sys

input = sys.stdin.readline

T = int(input().rstrip())
stack = []

for _ in range(T):
    cmd = list(map(int, input().rstrip().split()))
    if cmd[0] == 1:
        stack.append(cmd[1])
    elif cmd[0] == 2:
        if stack:
            print(stack[-1])
            stack.pop(-1)
        else:
            print(-1)
    elif cmd[0] == 3:
        print(len(stack))
    elif cmd[0] == 4:
        if stack:
            print(0)
        else:
            print(1)
    else:
        if stack:
            print(stack[-1])
        else:
            print(-1)

import sys

input = sys.stdin.readline
n = int(input())
arr = []
for _ in range(n):
    cmd = list(map(str, input().split()))
    if len(cmd) == 2:
        arr.append(int(cmd[1]))
    else:
        if cmd[0] == "pop":
            if arr:
                print(arr[0])
                arr.pop(0)
            else:
                print(-1)
        elif cmd[0] == "size":
            print(len(arr))
        elif cmd[0] == "empty":
            if arr:
                print(0)
            else:
                print(1)
        elif cmd[0] == "front":
            if arr:
                print(arr[0])
            else:
                print(-1)
        elif cmd[0] == "back":
            if arr:
                print(arr[-1])
            else:
                print(-1)

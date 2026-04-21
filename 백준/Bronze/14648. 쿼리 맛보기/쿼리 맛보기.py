import sys

input = sys.stdin.readline

n, q = map(int, input().split())
arr = list(map(int, input().split()))
for _ in range(q):
    cmd = list(map(int, input().split()))
    if cmd[0] == 1:
        a, b = cmd[1] - 1, cmd[2]
        answer = sum(arr[a:b])
        print(answer)
        arr[a], arr[b - 1] = arr[b - 1], arr[a]
    elif cmd[0] == 2:
        a, b, c, d = cmd[1] - 1, cmd[2], cmd[3] - 1, cmd[4]
        answer = sum(arr[a:b]) - sum(arr[c:d])
        print(answer)

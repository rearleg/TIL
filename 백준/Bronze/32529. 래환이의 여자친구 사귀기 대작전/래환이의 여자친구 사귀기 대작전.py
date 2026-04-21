import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

arr = arr[::-1]

weight = 0
cnt = 0

if sum(arr) < M:
    print(-1)
else:
    for i in arr:
        if weight >= M:
            break
        weight += i
        cnt += 1

    print(N - cnt + 1)
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())

if M + (N - 1) > K:
    print("NO")
else:
    print("YES")
    lst = [[0] * M for _ in range(N)]
    x = 1
    for i in range(N):
        y = x
        for j in range(M):
            lst[i][j] = y
            y += 1
        x += 1
    lst[N - 1][M - 1] = K

    for k in range(N):
        print(" ".join(map(str, lst[k])))

import sys

input = sys.stdin.readline

N = int(input().strip())
body = [tuple(map(int, input().split())) for _ in range(N)]

ranks = []

for i in range(N):
    w_i, h_i = body[i]
    cnt = 1
    for j in range(N):
        w_j, h_j = body[j]
        if w_j > w_i and h_j > h_i:
            cnt += 1
    ranks.append(cnt)

print(*ranks)

import sys

input = sys.stdin.readline


N, M, K = map(int, input().split())
d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
arr = [[0] * (M + 1) for _ in range(N + 1)]
ans = 0

for _ in range(K):
    a, b = map(int, input().split())
    arr[a][b] = 1
for r in range(1, N + 1):
    for c in range(1, M + 1):

        if arr[r][c] == 1:
            stack = [(r, c)]
            arr[r][c] = 0
            cnt = 1
            while stack:
                cr, cc = stack.pop()
                for dr, dc in d:
                    nr, nc = cr + dr, cc + dc
                    if 1 <= nr <= N and 1 <= nc <= M and arr[nr][nc] == 1:
                        arr[nr][nc] = 0
                        stack.append((nr, nc))
                        cnt += 1
            ans = max(ans, cnt)
print(ans)

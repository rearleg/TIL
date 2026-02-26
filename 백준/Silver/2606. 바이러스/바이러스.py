import sys
from collections import deque

input = sys.stdin.readline


N = int(input())
M = int(input())
g = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

visited = [False] * (N + 1)
queue = deque([1])
visited[1] = True
cnt = 0
while queue:
    cur = queue.popleft()
    for n in g[cur]:
        if not visited[n]:
            visited[n] = True
            queue.append(n)
            cnt += 1

print(cnt)
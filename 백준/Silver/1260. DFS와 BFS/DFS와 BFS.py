import sys
from collections import deque

input = sys.stdin.readline

# 입력 받기
N, M, V = map(int, input().split())
g = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

for i in range(1, N + 1):
    g[i].sort()

# DFS
visited = [False] * (N + 1)
stack = [V]
dfs_answer = []

while stack:
    v = stack.pop()
    if visited[v]:
        continue

    visited[v] = True
    dfs_answer.append(v)

    for nxt in reversed(g[v]):
        if not visited[nxt]:
            stack.append(nxt)
print(*dfs_answer)

# BFS
visited = [False] * (N + 1)
queue = deque([V])
visited[V] = True
bfs_answer = []

while queue:
    v = queue.popleft()
    bfs_answer.append(v)

    for nxt in g[v]:
        if not visited[nxt]:
            visited[nxt] = True
            queue.append(nxt)

print(*bfs_answer)

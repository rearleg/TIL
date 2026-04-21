import sys
from collections import deque

input = sys.stdin.readline
n, k = map(int, input().split())

dq = deque(range(1, n + 1))
result = []
while dq:
    for _ in range(k - 1):
        dq.append(dq.popleft())

    result.append(dq.popleft())

print(f"<{', '.join(map(str, result))}>")

import sys
from collections import deque

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    arr = deque([0] * N)
    arr[M] = 1
    priority = deque(map(int, input().split()))
    cnt = 1
    while len(arr) > 0:
        max_num = max(priority)
        # 최우선 나오때까지 회전
        if priority[0] != max_num:
            priority.append(priority.popleft())
            arr.append(arr.popleft())
        else:
            num = arr.popleft()
            priority.popleft()
            if num == 1:
                print(cnt)
                break
            else:
                cnt += 1

import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
lst = deque(map(int, input().split()))
dq = deque(range(1, n + 1))
result = []

# 첫번째는 무조건 터트리고 시작

temp = lst[0]
result.append(dq.popleft())
lst.popleft()

# 두번째부터는 dq가 사라질때까지 반복
while dq:
    # temp가 음수인지 양수인지에 따라 분기 설정
    if temp > 0:
        for _ in range(temp - 1):
            # 오른쪽으로 회전
            lst.append(lst.popleft())
            dq.append(dq.popleft())
        temp = lst[0]
        result.append(dq.popleft())
        lst.popleft()
    else:
        for _ in range((temp * -1)):
            # 왼쪽으로 회전
            lst.appendleft(lst.pop())
            dq.appendleft(dq.pop())
        temp = lst[0]
        result.append(dq.popleft())
        lst.popleft()

print(" ".join(map(str, result)))

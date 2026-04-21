import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
QS = list(map(int, input().rstrip().split()))
lst = list(map(int, input().rstrip().split()))
cmd_n = int(input().rstrip())
cmd = list(map(int, input().rstrip().split()))

rtn = []

# stack은 결과에 관련 없으니 queue만 따로 모아서 deque로 만듦
dq = deque()
for i in range(n):
    if QS[i] == 0:
        dq.appendleft(lst[i])

for cm in cmd:
    # queue에는 기존 값이 삭제되고 cm이나 최근 temp가 남을테니
    # cmd을 dq에 추가하고 기존 값을 제거, temp로 업데이트(Pop한 걸 업데이트 한다고함)
    dq.append(cm)
    temp = dq.popleft()
    # temp로 업데이트 된 걸 rtn에 추가
    rtn.append(temp)

print(" ".join(map(str, rtn)))
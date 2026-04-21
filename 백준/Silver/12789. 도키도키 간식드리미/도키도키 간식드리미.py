import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
line = deque(map(int, input().rstrip().split()))
stack = []
gansik = 1

while line:
    # 1. 스택으로 빠진 사람들 순서가 맞다면 순차적으로 입장
    while stack and stack[-1] == gansik:
        gansik += 1
        stack.pop()
    
    # 2-1. 앞 줄에 서있는 사람이 순서라면 입장
    if line[0] == gansik:
        gansik += 1
        line.popleft()
    # 2-2. 아니라면 스택으로 빠짐
    else:
        stack.append(line.popleft())


# 3. 줄이 전부 비면 스택에서 다시 한번 체크
while stack and stack[-1] == gansik:
    gansik += 1
    stack.pop()

# 4. 이 과정을 다 겪고도 남아 있으면 간식 못 먹음
if not line and not stack:
    print('Nice')
else:
    print('Sad')
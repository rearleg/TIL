import sys
from collections import deque

input = sys.stdin.readline

W = int(input())
T = int(input())
train = []

for _ in range(T):
    train.append(int(input()))

br = deque()
current_weight = 0
answer = T

for i in range(T):
    new_train = train[i]

    if len(br) == 4:
        out_train = br.popleft()
        current_weight -= out_train

    br.append(new_train)
    current_weight += new_train

    if current_weight > W:
        answer = i
        break

print(answer)

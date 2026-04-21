import sys

input = sys.stdin.readline

N = int(input())
P = sorted(list(map(int, input().split())))
answer = []
T = 0
for i in P:
    answer.append(T + i)
    T += i

print(sum(answer))

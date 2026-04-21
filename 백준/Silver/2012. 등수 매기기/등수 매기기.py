import sys

input = sys.stdin.readline

N = int(input())
arr = sorted(list(map(int, sys.stdin.readlines())))
answer = 0
for i in range(N):
    answer += abs(arr[i] - (i + 1))

print(answer)

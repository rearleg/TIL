import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
v = int(input())
cnt = 0

for i in lst:
    if i == v:
        cnt += 1

print(cnt)
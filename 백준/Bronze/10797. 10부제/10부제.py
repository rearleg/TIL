import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
temp = 0

for i in lst:
    if i == n:
        temp += 1

print(temp)
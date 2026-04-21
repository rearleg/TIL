import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
lst = list(map(int, input().split()))
lst.sort()
cnt = 0
i = 0
j = n - 1

while i < j:
    if lst[i] + lst[j] > m:
        j -= 1
    elif lst[i] + lst[j] < m:
        i += 1
    elif lst[i] + lst[j] == m:
        cnt += 1
        i += 1
        j -= 1

print(cnt)
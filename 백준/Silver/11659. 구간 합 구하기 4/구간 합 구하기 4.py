import sys
input = sys.stdin.readline
n, m = map(int, input().split())
lst = list(map(int, input().split()))
temp = 0
prefix_sum = [0]

for i in lst:
    temp += i
    prefix_sum.append(temp)

for _ in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i-1])
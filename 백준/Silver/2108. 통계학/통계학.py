# 1874번 문제 풀어라

import sys

input = sys.stdin.readline
T = int(input())
lst = []

for _ in range(T):
    n = int(input())
    lst.append(n)

lst.sort()

count = {}
for i in lst:
    count[i] = count.get(i, 0) + 1

max_freq = max(count.values())
mode = [k for k, v in count.items() if v == max_freq]
if len(mode) > 1:
    mode.sort()
    x = mode[1]
else:
    x = mode[0]

if sum(lst) < 0:
    print(int(sum(lst) / T - 0.5))
else:
    print(int(sum(lst) / T + 0.5))
print(lst[T // 2])
print(x)
print(max(lst) - min(lst))

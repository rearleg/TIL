import sys

input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))

answer = 0
c1 = c2 = c3 = c4 = 0

for i in lst:
    if i == 4:
        c4 += 1
    elif i == 3:
        c3 += 1
    elif i == 2:
        c2 += 1
    else:
        c1 += 1

answer += c4

answer += c3
use = min(c1, c3)
c1 -= use

answer += c2 // 2
c2 = c2 % 2

if c2 == 1:
    answer += 1
    c1 -= min(c1, 2)

answer += (c1 + 3) // 4

print(answer)

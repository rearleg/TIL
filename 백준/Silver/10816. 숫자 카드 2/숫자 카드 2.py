import sys
from bisect import bisect_right, bisect_left

input = sys.stdin.readline

n = int(input())
card = sorted(list(map(int, input().split())))
m = int(input())
target = list(map(int, input().split()))

result = []
for tg in target:
    cnt = bisect_right(card, tg) - bisect_left(card, tg)
    result.append(cnt)

print(" ".join(map(str, result)))

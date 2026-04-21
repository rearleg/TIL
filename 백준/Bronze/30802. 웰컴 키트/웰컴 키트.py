import sys
import math
input = sys.stdin.readline

n = int(input())
t = list(map(int, input().split()))
tg, pg = map(int, input().split())
to = 0


for i in t:
    to += math.ceil(i/tg)

print(to)
print(n//pg, n%pg)
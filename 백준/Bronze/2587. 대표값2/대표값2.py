import sys

n = sorted(list(map(int, sys.stdin.readlines())))
print(int(sum(n) / 5))
print(n[2])

import sys

n = sorted(list(map(int, sys.stdin.readlines()[1:])))
print("\n".join(map(str, n)))
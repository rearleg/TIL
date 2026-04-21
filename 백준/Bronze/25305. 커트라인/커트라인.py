import sys

input = sys.stdin.readline
N, k = map(int, input().rstrip().split())
l = sorted(list(map(int, input().rstrip().split())), reverse=True)
print(l[k - 1])

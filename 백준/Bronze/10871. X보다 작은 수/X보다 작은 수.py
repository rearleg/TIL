import sys
input = sys.stdin.readline

_, x = map(int, input().split())
lst = list(map(int, input().split()))
result = []

for i in lst:
    if i < x:
        result.append(i)

print(' '.join(map(str, result)))
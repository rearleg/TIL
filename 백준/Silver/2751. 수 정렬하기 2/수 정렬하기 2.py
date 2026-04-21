import sys
input = sys.stdin.readline

n = int(input().strip())
lst = list(int(input().strip()) for _ in range(n))
lst.sort()
for i in lst:
    print(i)
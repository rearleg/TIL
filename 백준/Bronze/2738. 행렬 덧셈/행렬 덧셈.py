import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
B = [list(map(int, input().split())) for _ in range(n)]
lst = [[0 for _ in range(m)] for _ in range(n)]
result = []

for i in range(n):
    for j in range(m):
        lst[i][j] = A[i][j] + B[i][j]

for row in lst:
    print(' '.join(map(str, row)))
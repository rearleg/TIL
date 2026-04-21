n, m = map(int, input().split())

lst = [0] * n

for _ in range(m):
    i, j, k = map(int, input().split())
    for x in range(i-1, j):
        lst[x] = k

print(' '.join(map(str, lst)))

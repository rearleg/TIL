n, m = map(int, input().split())
lst = [k+1 for k in range(n)]
for _ in range(m):
    i, j = map(int, input().split())
    lst[i-1], lst[j-1] = lst[j-1], lst[i-1]

print(*lst)
